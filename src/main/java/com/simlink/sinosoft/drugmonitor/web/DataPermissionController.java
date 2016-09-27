package com.simlink.sinosoft.drugmonitor.web;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import com.simlink.sinosoft.drugmonitor.service.DataPermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/dataPermission")
public class DataPermissionController extends BaseController {

    @Autowired
    private DataPermissionService dataPermissionService;

    @RequestMapping("clientManage")
    @RequiresPermissions("data:permission:client")
    public String clientManage(){
        return "dataPermission/clientManage";
    }

    @RequestMapping("getClients")
    @RequiresPermissions("data:permission:client")
    @ResponseBody
    public List<DataClient> getClients(DataClient client,Integer page,Integer rows){
        PageBounds pb= new PageBounds(page,rows);
        List<DataClient> clients = dataPermissionService.getClients(client,pb);
        return clients;
    }

    @RequestMapping("areaManage")
    @RequiresPermissions("data:permission:area")
    public String areaManage(){
        return "dataPermission/areaManage";
    }

    @RequestMapping("organizationManage")
    @RequiresPermissions("data:permission:organization")
    public String organizationManage(){
        return "dataPermission/organizationManage";
    }
}
