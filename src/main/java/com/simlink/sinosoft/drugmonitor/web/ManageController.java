package com.simlink.sinosoft.drugmonitor.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.entity.Query;
import com.simlink.sinosoft.drugmonitor.service.ErpDataService;
import com.simlink.sinosoft.drugmonitor.service.ManageService;
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
 * 经营分析
 * Created by Administrator on 2016/10/3 0003.
 */
@Controller
@RequestMapping("/manage")
public class ManageController extends BaseController {

    @Autowired
    private ErpDataService erpDataService;

    @RequestMapping("purchase")
    @RequiresPermissions("business:manage:purchase")
    public String purchase(Model model){
        return "manage/purchase";
    }

    @RequestMapping("purchaseData")
    @RequiresPermissions("business:manage:purchase")
    @ResponseBody
    public List<Map<String,Object>> purchaseData(Query query, String startDate, String endDate){
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));

        return erpDataService.purchaseData(query);
    }


    @RequestMapping("purchaseDetail")
    @RequiresPermissions("business:manage:purchaseDetail")
    public String purchaseDetail(){
        return "manage/purchaseDetail";
    }

    @RequestMapping("prescription")
    @RequiresPermissions("business:manage:prescription")
    public String prescription(){
        return "manage/prescription";
    }

    @RequestMapping("prescriptionDetail")
    @RequiresPermissions("business:manage:presDetail")
    public String presDetail(){
        return "manage/presDetail";
    }

    @RequestMapping("prescriptionData")
    @RequiresPermissions(value = {"business:manage:prescription","business:manage:presDetail"},logical = Logical.OR)
    @ResponseBody
    public List<Map<String,Object>> prescriptionData(Query query, String startDate, String endDate){
        query.setStartDate(DateUtils.parseDate(startDate));
        query.setEndDate(DateUtils.parseDate(endDate));

        return erpDataService.prescriptionData(query);
    }
}
