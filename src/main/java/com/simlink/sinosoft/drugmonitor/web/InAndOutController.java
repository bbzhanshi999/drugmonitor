package com.simlink.sinosoft.drugmonitor.web;

import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.service.InAndOutService;
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
@RequestMapping("/inAndOut")
public class InAndOutController extends BaseController {

    @Autowired
    private InAndOutService inAndOutService;

    @RequestMapping("in")
    @RequiresPermissions("business:inAndOut:in")
    public String drugIn(Model model){
        defaultDate(model);
        return "inAndOut/drugIn";
    }

    @RequestMapping("inData")
    @RequiresPermissions("business:inAndOut:in")
    @ResponseBody
    public List<Map<String,Object>> inData(String year, String season, String month,String drugName){
        List<Map<String,Object>> results;
        Map<String,Object> query = Maps.newHashMap();
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        query.put("endDate",dateRange.getEndDate());
        query.put("startDate",dateRange.getStartDate());
        query.put("drugName",drugName);
        results = inAndOutService.drugInData(query);
        return results;
    }


    @RequestMapping("out")
    @RequiresPermissions("business:inAndOut:out")
    public String drugOut(Model model){
        defaultDate(model);
        return "inAndOut/drugOut";
    }

    @RequestMapping("outData")
    @RequiresPermissions("business:inAndOut:out")
    @ResponseBody
    public List<Map<String,Object>> outData(String year, String season, String month,String drugName){
        List<Map<String,Object>> results;
        Map<String,Object> query = Maps.newHashMap();
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        query.put("endDate",dateRange.getEndDate());
        query.put("startDate",dateRange.getStartDate());
        query.put("drugName",drugName);
        results = inAndOutService.drugOutData(query);
        return results;
    }

    @RequestMapping("getDrugNames")
    @RequiresPermissions("business")
    @ResponseBody
    public List<Map<String,Object>> getDrugNames(){
        List<Map<String,Object>> results = inAndOutService.getDrugNames();
        return results;
    }
}
