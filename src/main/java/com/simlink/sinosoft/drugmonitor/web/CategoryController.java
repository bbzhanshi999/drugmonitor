package com.simlink.sinosoft.drugmonitor.web;

import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.service.CategoryService;
import com.simlink.sinosoft.drugmonitor.service.ErpDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 进销存
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping("outstore")
    @RequiresPermissions("business:category:outstore")
    public String outstore(Model model){
        defaultDate(model);
        return "category/outstore";
    }

    @RequestMapping("outData")
    @RequiresPermissions("business:category:outstore")
    @ResponseBody
    public List<Map<String,Object>> outData(String year, String season, String month,String category){
        List<Map<String,Object>> results;
        Map<String,Object> query = Maps.newHashMap();
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        query.put("endDate",dateRange.getEndDate());
        query.put("startDate",dateRange.getStartDate());
        query.put("category",category);
        results = categoryService.outData(query);
        return results;
    }


    @RequestMapping("supply")
    @RequiresPermissions("business:category:supply")
    public String supply(Model model){
        defaultDate(model);
        return "category/supply";
    }


    @RequestMapping("supplyData")
    @RequiresPermissions("business:category:supply")
    @ResponseBody
    public List<Map<String,Object>> supplyData(String year, String season, String month,String category){
        List<Map<String,Object>> results;
        Map<String,Object> query = Maps.newHashMap();
        DateUtils.DateRange dateRange = DateUtils.getDateRange(year, season, month);
        query.put("endDate",dateRange.getEndDate());
        query.put("startDate",dateRange.getStartDate());
        query.put("category",category);
        results = categoryService.supplyData(query);
        return results;
    }
}
