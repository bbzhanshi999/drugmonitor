package com.simlink.sinosoft.drugmonitor.web;

import com.simlink.common.utils.DateUtils;
import com.simlink.common.web.BaseController;

import java.util.Date;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 进销存控制器
 * Created by Administrator on 2016/9/23 0023.
 */
@Controller
@RequestMapping("/erp")
public class ERPController extends BaseController {


    @RequestMapping("instore")
    @RequiresPermissions("business:erp:instore")
    public String instore(Model model){
        Date date = new Date();
        int year = DateUtils.getYear(date);
        int month = DateUtils.getMonth(date);
        int season = DateUtils.getSeason(date);
        model.addAttribute("initYear",year);
        model.addAttribute("initMonth",month);
        model.addAttribute("initSeason",season);
        return "erp/instore";
    }

    @RequestMapping("outstore")
    @RequiresPermissions("business:erp:outstore")
    public String outstore(){
        return "erp/outstore";
    }
}
