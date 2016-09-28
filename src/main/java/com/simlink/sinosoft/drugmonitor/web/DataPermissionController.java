package com.simlink.sinosoft.drugmonitor.web;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.google.common.collect.Maps;
import com.simlink.common.entity.User;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.utils.UserUtils;
import com.simlink.common.web.BaseController;
import com.simlink.sinosoft.drugmonitor.entity.Area;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import com.simlink.sinosoft.drugmonitor.entity.Organization;
import com.simlink.sinosoft.drugmonitor.service.DataPermissionService;
import com.simlink.sinosoft.drugmonitor.utils.DataClientUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


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
        PageBounds pb;
        if(page==null||rows==null){
            pb= new PageBounds();
        }else{
            pb= new PageBounds(page,rows);
        }
        List<DataClient> clients = dataPermissionService.getClients(client,pb);
        return clients;
    }

    @RequestMapping("createClient")
    @RequiresPermissions("data:permission:client")
    @ResponseBody
    public Map<String,Object> createClient(DataClient client){
        dataPermissionService.createClient(client);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("updateClient")
    @RequiresPermissions("data:permission:client")
    @ResponseBody
    public Map<String,Object> updateClient(DataClient client){
        dataPermissionService.updateClient(client);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("deleteClient")
    @RequiresPermissions("data:permission:client")
    @ResponseBody
    public Map<String,Object> deleteClient(String id){
        dataPermissionService.deleteClient(id);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("areaManage")
    @RequiresPermissions("data:permission:area")
    public String areaManage(){
        return "dataPermission/areaManage";
    }

    @RequestMapping("getAreas")
    @RequiresPermissions("data:permission:area")
    @ResponseBody
    public List<Area> getAreas(Area area,Integer page,Integer rows){
        PageBounds pb;
        if(page==null||rows==null){
            pb= new PageBounds();
        }else{
            pb= new PageBounds(page,rows);
        }
        List<Area> result= dataPermissionService.getAreas(area,pb);
        return result;
    }

    @RequestMapping("createArea")
    @RequiresPermissions("data:permission:area")
    @ResponseBody
    public Map<String,Object> createArea(Area area){
        dataPermissionService.createArea(area);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("updateArea")
    @RequiresPermissions("data:permission:area")
    @ResponseBody
    public Map<String,Object> updateArea(Area area){
        dataPermissionService.updateArea(area);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("deleteArea")
    @RequiresPermissions("data:permission:area")
    @ResponseBody
    public Map<String,Object> deleteArea(String id){
        dataPermissionService.deleteArea(id);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("organizationManage")
    @RequiresPermissions("data:permission:organization")
    public String organizationManage(){
        return "dataPermission/organizationManage";
    }


    @RequestMapping("getOrganizations")
    @RequiresPermissions("data:permission:organization")
    @ResponseBody
    public List<Organization> getOrganizations(Organization organization, Integer page, Integer rows){
        PageBounds pb;
        if(page==null||rows==null){
            pb= new PageBounds();
        }else{
            pb= new PageBounds(page,rows);
        }
        List<Organization> result= dataPermissionService.getOrganization(organization,pb);
        return result;
    }

    @RequestMapping("createOrganization")
    @RequiresPermissions("data:permission:organization")
    @ResponseBody
    public Map<String,Object> createOrganization(Organization organization){
        dataPermissionService.createOrganization(organization);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("updateOrganization")
    @RequiresPermissions("data:permission:organization")
    @ResponseBody
    public Map<String,Object> updateOrganization(Organization organization){
        dataPermissionService.updateOrganization(organization);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("deleteOrganization")
    @RequiresPermissions("data:permission:organization")
    @ResponseBody
    public Map<String,Object> deleteOrganization(String id){
        dataPermissionService.deleteOrganization(id);
        Map<String,Object> result = Maps.newHashMap();
        result.put("success",true);
        return result;
    }

    @RequestMapping("clientNameValidate")
    @ResponseBody
    public Boolean clientNameValidate(String clientName){
        DataClient client = DataClientUtil.getClient(clientName);
        if(client!=null&& StringUtils.isNotBlank(client.getId())){
            return false;
        }
        return true;
    }
}
