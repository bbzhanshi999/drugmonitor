package com.simlink.sinosoft.drugmonitor.web;

import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.entity.Query;
import com.simlink.sinosoft.drugmonitor.service.ErpDataService;
import com.simlink.sinosoft.drugmonitor.service.VaccineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 疫苗
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@RequestMapping("/vaccine")
public class VaccineController extends BaseController {

    @Autowired
    private ErpDataService erpDataService;


    @RequestMapping("use")
    @RequiresPermissions("business:vaccine:use")
    public String outstore(Model model){
        defaultDate(model);
        return "vaccine/use";
    }



    @RequestMapping("instore")
    @RequiresPermissions("business:vaccine:instore")
    public String instore(Model model){
        return "vaccine/instore";
    }


}
