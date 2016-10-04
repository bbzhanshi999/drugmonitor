package com.simlink.sinosoft.drugmonitor.web;

import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.simlink.sinosoft.drugmonitor.service.ErpDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 进销存
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@RequestMapping("/erp")
public class ERPController extends BaseController {

    @Autowired
    private ErpDataService erpDataService;

    @RequestMapping("instore")
    @RequiresPermissions("business:erp:instore")
    public String instore(Model model){
        defaultDate(model);
        return "erp/instore";
    }

    @RequestMapping("instoreData")
    @RequiresPermissions("business:erp:instore")
    @ResponseBody
    public List<Map<String,Object>> instoreData(String year, String season, String month){
        List<Map<String,Object>> results;
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        results = erpDataService.instoreData(dateRange);
        return results;
    }

    @RequestMapping("outstore")
    @RequiresPermissions("business:erp:outstore")
    public String outstore(Model model){
        defaultDate(model);
        return "erp/outstore";
    }

    @RequestMapping("outstoreData")
    @RequiresPermissions("business:erp:outstore")
    @ResponseBody
    public List<Map<String,Object>> outstoreData(String year, String season, String month){
        List<Map<String,Object>> results;
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        results = erpDataService.outstoreData(dateRange);
        return results;
    }


    @RequestMapping("storage")
    @RequiresPermissions("business:erp:storage")
    public String storage(Model model){
        defaultDate(model);
        return "erp/storage";
    }


    @RequestMapping("storageData")
    @RequiresPermissions("business:erp:storage")
    @ResponseBody
    public List<Map<String,Object>> storageData(String year, String season, String month){
        List<Map<String,Object>> results;
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        results = erpDataService.storageData(dateRange);
        return results;
    }
}
