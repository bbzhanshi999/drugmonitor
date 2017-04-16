package com.simlink.sinosoft.drugmonitor.web;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.entity.User;
import com.simlink.common.mapper.JsonMapper;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Map<String,Object> getClients(Integer page,Integer rows,DataClient client){
        Map<String,Object> result = Maps.newHashMap();
        PageBounds pb;
        if(page==null||rows==null){
            pb= new PageBounds();
        }else{
            pb= new PageBounds(page,rows);
        }

        Organization organization = new Organization(client.getOrganId(),client.getOrganName());
        client.setOrganization(organization);
        Area area = new Area(client.getAreaId(),client.getAreaName());
        client.setArea(area);
        List<DataClient> clients = dataPermissionService.getClients(client,pb);
        PageList pageList = (PageList)clients;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total",totalCount);
        result.put("rows",clients);
        return result;
    }

    @RequestMapping("createClient")
    @RequiresPermissions("data:permission:client")
    @ResponseBody
    public List<Object> createClient(DataClient client){
        List<Object> results = Lists.newArrayList();
        Map<String,Object> result = Maps.newHashMap();
        if(DataClientUtil.clientNameExist(client)){
            result.put("isError",true);
            result.put("msg","保存失败，用户名已存在");
            results.add(result);
            return results;
        }
        Organization organization = new Organization(client.getOrganId(),client.getOrganName());
        client.setOrganization(organization);
        Area area = new Area(client.getAreaId(),client.getAreaName());
        client.setArea(area);
        dataPermissionService.createClient(client);

        result.put("success",true);
        results.add(result);
        return results;
    }

    @RequestMapping("updateClient")
    @RequiresPermissions("data:permission:client")
    @ResponseBody
    public List<Object> updateClient(String id,String organId,String areaId,String clientName,String password){
        List<Object> results = Lists.newArrayList();
        Map<String,Object> result = Maps.newHashMap();
        Organization organization = new Organization();
        organization.setId(organId);
        Area area  = new Area();
        area.setId(areaId);
        DataClient client = new DataClient();
        client.setArea(area);
        client.setOrganization(organization);
        client.setClientName(clientName);
        client.setPassword(password);
        client.setId(id);
        if(DataClientUtil.clientNameExist(client)){
            result.put("isError",true);
            result.put("msg","保存失败，用户名已存在");
            results.add(result);
            return results;
        }
        dataPermissionService.updateClient(client);
        result.put("success",true);
        results.add(result);
        return results;
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
    public Map<String,Object> getAreas(Area area,Integer page,Integer rows){
        Map<String,Object> result = Maps.newHashMap();
        PageBounds pb;
        if(page==null||rows==null){
            pb= new PageBounds();
        }else{
            pb= new PageBounds(page,rows);
        }
        List<Area> areas= dataPermissionService.getAreas(area,pb);
        PageList pageList = (PageList)areas;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total",totalCount);
        result.put("rows",areas);
        return result;
    }

    @RequestMapping("getAllAreas")
    @RequiresPermissions("data:permission:area")
    @ResponseBody
    public List<Area> getAllAreas(){
        List<Area> areas= dataPermissionService.getAllAreas();
        return areas;
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
    public Map<String,Object> updateArea(String id,String areaName,String areaEname,String areaCode){
        Area area = new Area();
        area.setId(id);
        area.setAreaCode(areaCode);
        area.setAreaEname(areaEname);
        area.setAreaName(areaName);
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
    public Map<String,Object> getOrganizations(Organization organization, Integer page, Integer rows){
        Map<String,Object> result = Maps.newHashMap();
        PageBounds pb;
        if(page==null||rows==null){
            pb= new PageBounds();
        }else{
            pb= new PageBounds(page,rows);
        }
        List<Organization> organizations= dataPermissionService.getOrganization(organization,pb);
        PageList pageList = (PageList)organizations;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total",totalCount);
        result.put("rows",organizations);
        return result;
    }

    @RequestMapping("getAllOrganizations")
    @ResponseBody
    public List<Organization> getAllOrganizations(){
        List<Organization> organizations= dataPermissionService.getAllOrganizations();
        return organizations;
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
    public Map<String,Object> updateOrganization(String id,String organName,String organEname,String organCode){
        Organization organization = new Organization();
        organization.setId(id);
        organization.setOrganEname(organEname);
        organization.setOrganName(organName);
        organization.setOrganCode(organCode);
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
