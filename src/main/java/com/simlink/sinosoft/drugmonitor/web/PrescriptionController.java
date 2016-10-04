package com.simlink.sinosoft.drugmonitor.web;

import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.service.DistributeService;
import com.simlink.sinosoft.drugmonitor.service.PrescriptionService;
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
@RequestMapping("/prescription")
public class PrescriptionController extends BaseController {

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping("drug")
    @RequiresPermissions("business:prescription:drug")
    public String drugIn(Model model){
        defaultDate(model);
        return "prescription/drug";
    }

    @RequestMapping("drugData")
    @RequiresPermissions("business:prescription:drug")
    @ResponseBody
    public List<Map<String,Object>> drugData(String year, String season, String month,String drugName){
        List<Map<String,Object>> results;
        Map<String,Object> query = Maps.newHashMap();
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        query.put("endDate",dateRange.getEndDate());
        query.put("startDate",dateRange.getStartDate());
        query.put("drugName",drugName);
        results = prescriptionService.drugData(query);
        return results;
    }

    @RequestMapping("getDrugNames")
    @RequiresPermissions("business:prescription")
    @ResponseBody
    public List<Map<String,Object>> getDrugNames(){
        List<Map<String,Object>> results = prescriptionService.getDrugNames();
        return results;
    }
}
