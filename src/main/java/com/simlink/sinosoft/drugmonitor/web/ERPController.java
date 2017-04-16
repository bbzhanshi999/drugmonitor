package com.simlink.sinosoft.drugmonitor.web;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Maps;
import com.simlink.common.entity.Role;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.web.BaseController;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.simlink.sinosoft.drugmonitor.entity.Query;
import com.simlink.sinosoft.drugmonitor.service.ErpDataService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 流通监控
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@RequestMapping("/erp")
public class ERPController extends BaseController {

    @Autowired
    private ErpDataService erpDataService;

    @RequestMapping("instore")
    @RequiresPermissions("business:erp:instore")
    public String instore(Model model) {
        defaultDate(model);
        return "erp/instore";
    }


    @RequestMapping("instoreData")
    @RequiresPermissions(value={"business:erp:instore","business:erp:supporter"},logical= Logical.OR)
    @ResponseBody
    public List<Map<String, Object>> instoreData(Query query, String startDate, String endDate) {
        List<Map<String, Object>> results;
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        if (StringUtils.isBlank(query.getPeriod())) query.setPeriod("yyyy/mm/dd");
        results = erpDataService.instoreData(query);
        return results;
    }

    @RequestMapping("instoreDetail")
    @RequiresPermissions(value={"business:erp:instore","business:erp:storage","business:erp:supporter","business:vaccine:*"},logical= Logical.OR)
    @ResponseBody
    public Map<String, Object> instoreDetail(Query query, String startDate, String endDate, Integer page, Integer rows) {
        Map<String, Object> result = Maps.newHashMap();
        String order = "D_ACCEPTDATETIME.asc";
        PageBounds pb = new PageBounds(page, rows, Order.formString(order));
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        List<Map<String, Object>> results = erpDataService.instoreDataDetail(query, pb);
        PageList pageList = (PageList) results;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total", totalCount);
        result.put("rows", results);
        return result;
    }


    @RequestMapping("outstore")
    @RequiresPermissions("business:erp:outstore")
    public String outstore(Model model) {
        defaultDate(model);
        return "erp/outstore";
    }

    @RequestMapping("outstoreData")
    @RequiresPermissions(value={"business:erp:outstore","business:erp:returned"},logical= Logical.OR)
    @ResponseBody
    public List<Map<String, Object>> outstoreData(Query query, String startDate, String endDate) {
        List<Map<String, Object>> results;
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        if (StringUtils.isBlank(query.getPeriod())) query.setPeriod("yyyy/mm/dd");
        results = erpDataService.outstoreData(query);
        return results;
    }

    @RequestMapping("outstoreDetail")
    @RequiresPermissions(value={"business:erp:outstore","business:erp:storage","business:erp:returned","business:vaccine:*"},logical= Logical.OR)
    @ResponseBody
    public Map<String, Object> outstoreDetail(Query query, String startDate, String endDate, Integer page, Integer rows) {
        Map<String, Object> result = Maps.newHashMap();
        String order = "D_OUTDATETIME.asc";
        PageBounds pb = new PageBounds(page, rows, Order.formString(order));
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        List<Map<String, Object>> results = erpDataService.outstoreDataDetail(query, pb);
        PageList pageList = (PageList) results;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total", totalCount);
        result.put("rows", results);
        return result;
    }

    /**
     * 药品出入库汇总统计
     *
     * @param model
     * @return
     */
    @RequestMapping("storage")
    @RequiresPermissions("business:erp:storage")
    public String storage(Model model) {
        defaultDate(model);
        return "erp/storage";
    }


    @RequestMapping("storageData")
    @RequiresPermissions(value = {"business:erp:storage","business:vaccine:*"},logical = Logical.OR)
    @ResponseBody
    public Map<String,Object> storageData(Query query, String startDate, String endDate) {
        Map<String, Object> result = Maps.newHashMap();
        List<Map<String, Object>> out;
        List<Map<String, Object>> in;
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));
        if (StringUtils.isBlank(query.getPeriod())) query.setPeriod("yyyy/mm/dd");
        out = erpDataService.outstoreData(query);
        in = erpDataService.instoreData(query);
        result.put("inResult",in);
        result.put("outResult",out);
        return result;

    }

    @RequestMapping("returned")
    @RequiresPermissions("business:erp:returned")
    public String returned(Model model) {
        defaultDate(model);
        return "erp/returned";
    }

    @RequestMapping("supporter")
    @RequiresPermissions("business:erp:supporter")
    public String supporter(Model model) {
        defaultDate(model);
        return "erp/supporter";
    }


}
