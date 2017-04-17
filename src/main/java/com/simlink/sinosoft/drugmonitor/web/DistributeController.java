package com.simlink.sinosoft.drugmonitor.web;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.entity.Query;
import com.simlink.sinosoft.drugmonitor.service.DistributeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 电子监管码
 * Created by Administrator on 2016/10/3 0003.
 */
@Controller
@RequestMapping("/distribute")
public class DistributeController extends BaseController {

    @Autowired
    private DistributeService distributeService;

    @RequestMapping("scan")
    @RequiresPermissions("business:distribute:scan")
    public String scan(Model model){
        return "distribute/scan";
    }

    @RequestMapping("cycle")
    @RequiresPermissions("business:distribute:cycle")
    public String cycle(Model model){
        return "distribute/cycle";
    }

    @RequestMapping("scanData")
    @RequiresPermissions("business:distribute:scan")
    @ResponseBody
    public List<Map<String,Object>> scanData(Query query, String startDate, String endDate){
        List<Map<String, Object>> results;
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        if (StringUtils.isBlank(query.getPeriod())) query.setPeriod("yyyy/mm/dd");
        results = distributeService.scanData(query);
        return results;
    }

    @RequestMapping("getScanCycle")
    @RequiresPermissions("business:distribute:cycle")
    @ResponseBody
    public List<Map<String,Object>> getScanCycle(String code){
        List<Map<String, Object>> results;
        if(StringUtils.isBlank(code))return null;
        results = distributeService.getScanCycle(code);
        return results;
    }

    @RequestMapping("scanDetail")
    @RequiresPermissions("business:distribute:scan")
    @ResponseBody
    public Map<String, Object> scanDataDetail(Query query, String startDate, String endDate, Integer page, Integer rows) {
        Map<String, Object> result = Maps.newHashMap();
        String order = "D_ADDDATETIME.asc";
        PageBounds pb = new PageBounds(page, rows, Order.formString(order));
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        List<Map<String, Object>> results = distributeService.scanDataDetail(query, pb);
        PageList pageList = (PageList) results;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total", totalCount);
        result.put("rows", results);
        return result;
    }


    @RequestMapping("getDrugNames")
    @RequiresPermissions("business:distribute")
    @ResponseBody
    public List<Map<String,Object>> getDrugNames(){
        List<Map<String,Object>> results = distributeService.getDrugNames();
        return results;
    }
}
