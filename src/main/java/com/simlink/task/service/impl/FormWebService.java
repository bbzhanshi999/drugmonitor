package com.simlink.task.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import com.simlink.task.common.GenericResult;
import com.simlink.task.common.JaxbUtil;
import com.simlink.task.entity.TSiipDruginstore;
import com.simlink.task.entity.TSiipDruginstoredetail;
import com.simlink.task.service.FormService;
import com.simlink.task.service.IActionService;

/**
 * service公共处理入口 
 *
 */
@Service
public class FormWebService implements IActionService{
	private static final Logger log = LoggerFactory.getLogger(FormWebService.class);
	
	@Resource
	private FormService formService;
	@Resource
	private HttpServletRequest request;
	@Resource
	private JaxbUtil jaxbUtil;
	
	
	/**
	 * 药品入库主表 批量入库
	 */
	@SuppressWarnings({ "static-access", "rawtypes" })
	public GenericResult<Object> saveTSiipDruginstore(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		String desc=(String)request.getAttribute("desc");
		
		Element el = null;
		List<TSiipDruginstore> arrayList=new ArrayList<TSiipDruginstore>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstore tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstore.class);
			tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		log.info("+++++开始批量新增++++++");
		long startTime=System.currentTimeMillis();//获取开始时间  
		int batchResult=formService.saveAllTSiipDruginstore(arrayList);
		log.info("+++++批量新增结束++++++");
		long endTime=System.currentTimeMillis(); //获取结束时间 
		String spendTime=(endTime-startTime)/1000+"s";
		log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		return result;
	}
	/**
	 * 药品入库明细表 批量入库
	 */
	@SuppressWarnings({ "static-access", "rawtypes" })
	public GenericResult<Object> saveTSiipDruginstoredetail(Iterator lv, String version){
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
				
		return result;
	}
	/**
	 * 药品出库主表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings("rawtypes")
	public GenericResult<Object>  saveTSiipDrugoutstore(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
			result.setSuccess(true);
		}
				
		return result;
	}
	/**
	 * 药品出库明细表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipDrugoutstoredetail(Iterator lv, String version) throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
			
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
				
		return result;
	}
	/**
	 * 盘存库存记录主表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipDrugstoragestock(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
		return result;
	}
	/**
	 * 盘存库存记录表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipInvdrugstore(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
		return result;
	}
	/**
	 * 盘存库存记录明细表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipInvdrugstoredetail(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
		return result;
	}
	/**
	 * 发药汇总明细表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipSendcollectdetail(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
		return result;
	}
	/**
	 * 发药单主表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipSendlist(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
				
		return result;
	}
	/**
	 * 发药单药品汇总主表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipSendlistcollect(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
		return result;
	}
	/**
	 * 发药单明细表  高效批量入库
	 * @param entityList 列表
	 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public GenericResult<Object>  saveTSiipSendlistdetail(Iterator lv, String version)throws SQLException{
		GenericResult<Object> result = new GenericResult<Object>();
		//获取登录对象
		DataClient client=(DataClient)request.getAttribute("dataClient");
		Element el = null;
		List<TSiipDruginstoredetail> arrayList=new ArrayList<TSiipDruginstoredetail>();
		while (lv.hasNext()) {  
	        el = (Element) lv.next();
	        TSiipDruginstoredetail tds =jaxbUtil.converyToJavaBean(el.asXML(), TSiipDruginstoredetail.class);
	        tds.setInstitution(client.getOrganName());//机构名称
			tds.setArea(client.getAreaName());//区域名称
	        arrayList.add(tds);
	    }
		if(arrayList.isEmpty()||arrayList==null){
			result.setMessage("业务数据为空，无数据上传！");
			result.setSuccess(false);
		}else{
			log.info("+++++开始批量新增++++++");
			long startTime=System.currentTimeMillis();//获取开始时间  
			int batchResult=formService.saveTSiipDruginstoredetail(arrayList);
			log.info("+++++批量新增结束++++++");
			long endTime=System.currentTimeMillis(); //获取结束时间 
			String spendTime=(endTime-startTime)/1000+"s";
			log.info(spendTime+"时间内入库"+batchResult+"条数据,若存在问题请核对！");
		}
		return result;
	}
}
