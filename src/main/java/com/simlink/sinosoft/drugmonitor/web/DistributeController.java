package com.simlink.sinosoft.drugmonitor.web;

import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.service.DistributeService;
import com.simlink.sinosoft.drugmonitor.service.SupplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 药品出入
 * Created by Administrator on 2016/10/3 0003.
 */
@Controller
@RequestMapping("/distribute")
public class DistributeController extends BaseController {

    @Autowired
    private DistributeService distributeService;

    @RequestMapping("drug")
    @RequiresPermissions("business:distribute:drug")
    public String drugIn(Model model){
        defaultDate(model);
        return "distribute/drug";
    }

    @RequestMapping("drugData")
    @RequiresPermissions("business:distribute:drug")
    @ResponseBody
    public List<Map<String,Object>> drugData(String year, String season, String month,String drugName){
        List<Map<String,Object>> results;
        Map<String,Object> query = Maps.newHashMap();
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        query.put("endDate",dateRange.getEndDate());
        query.put("startDate",dateRange.getStartDate());
        query.put("drugName",drugName);
        results = distributeService.drugData(query);
        return results;
    }

    @RequestMapping("getDrugNames")
    @RequiresPermissions("business:distribute")
    @ResponseBody
    public List<Map<String,Object>> getDrugNames(){
        List<Map<String,Object>> results = distributeService.getDrugNames();
        return results;
    }
}
