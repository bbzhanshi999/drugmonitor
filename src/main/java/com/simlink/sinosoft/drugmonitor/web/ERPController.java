package com.simlink.sinosoft.drugmonitor.web;

import com.simlink.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
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
    public String instore(){

        return "erp/instore";
    }

    @RequestMapping("outstore")
    @RequiresPermissions("business:erp:outstore")
    public String outstore(){
        return "erp/outstore";
    }
}
