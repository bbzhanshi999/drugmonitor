package com.simlink.task.controller;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import com.simlink.sinosoft.drugmonitor.utils.DataClientUtil;
import com.simlink.task.common.GenericResult;
import com.simlink.task.common.JaxbUtil;
import com.simlink.task.service.IActionService;

//import com.neu.framework.consts.CommonConst;
//import com.neu.framework.consts.ResultConst;
//import com.neu.framework.lang.GenericResult;
//import com.neu.framework.page.Page;
//import com.neu.portal.common.consts.Constants;
//import com.neu.portal.common.service.IActionService;
//import com.neu.portal.common.utils.DateUtils;

@Controller
public class ServiceController extends BasicController{

	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	 
//	protected Document doc = null;
	@Autowired
	private DataClientUtil dataClientUtil;
	@Resource
	private JaxbUtil jaxbUtil;
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@ResponseBody
	@RequestMapping("/clientService")
	public String requestDispatcher(HttpServletRequest request) throws Exception {	
		Long startTimes = System.currentTimeMillis();
		GenericResult<Object> result = new GenericResult<Object>();
		InputStream in = request.getInputStream();  
		Iterator lvTable=null;
		String loginName="";
		String loginPwd="";
		String methodName="";//访问service
		String desc="";//上传业务名称
		
        try {  
        	Element el = null;
            Document document = loadFromInputStream(in);  
            Element element = document.getRootElement();  
            Iterator lvPro = element.elementIterator("props");
//            lvTable = element.elementIterator("rows");
            lvTable= element.element("rows").elementIterator("row");
            if (lvPro.hasNext()) {  
                el = (Element) lvPro.next(); 
                loginName=el.elementTextTrim("loginName");
                loginPwd=el.elementTextTrim("loginPwd");
                methodName=el.elementTextTrim("method");
                desc=el.elementTextTrim("desc");
            } 
          //获取用户登录对象
            DataClient dataClient=dataClientUtil.getClient(loginName);
            //校验用户名密码是否正确
            if(dataClient!=null&&loginPwd.equals(dataClient.getPassword())){
            	//传递登录用户对象，获取“区域”、“机构”数据
            	request.setAttribute("dataClient", dataClient);
            	request.setAttribute("desc", desc);
            	ApplicationContext ac  =  WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext()); 
    			IActionService actionService = (IActionService)ac.getBean("formWebService");
    			Method method = actionService.getClass().getMethod(methodName, Iterator.class, String.class);
    			method.setAccessible(true);
    			result = (GenericResult<Object>)method.invoke(actionService, lvTable,null);
    			Long endTimes = System.currentTimeMillis();
    			logger.info("请求地址:" + methodName+"总时长："+String.valueOf(endTimes-startTimes));
            }else{
            	logger.info(loginName+"登录验证不通过");
    			return jaxbUtil.setBackResult("登录验证不通过，请校验用户名与密码是否正确",desc);
    		}
        }catch(NoSuchElementException e){
        	logger.info("未获取制定根节点："+e.toString());
			e.printStackTrace();
			return jaxbUtil.setBackResult("未获取制定根节点，存在问题上传失败！",desc);
        }catch(InvocationTargetException e){
        	logger.info("数据存在问题无法上传："+e.toString());
			e.printStackTrace();
			return jaxbUtil.setBackResult("请校验数据，存在问题上传失败！",desc);
		}catch (NullPointerException e)  {  
        	logger.info("XML数据格式存在问题："+e.toString());
			e.printStackTrace();
			return jaxbUtil.setBackResult("请校验XML数据格式，存在问题上传失败！",desc);
		} catch (Exception e)  {  
        	logger.info("批量入库出错，错误日志："+e.toString());
			e.printStackTrace();
			return jaxbUtil.setBackResult("批量入库出错！",desc);
		} 
		//除了出现异常之外的情况返回执行信息，如数据为空的情况
        if(!result.isSuccess())
        	return jaxbUtil.setBackResult(result.getMessage(),desc);
        
		return jaxbUtil.setBackResult("",desc);
		
	}
	
	public Document loadFromInputStream(InputStream input)  {
		DOMReader domReader= new DOMReader();  
		Document doc=null;
		DocumentBuilderFactory   dbf = DocumentBuilderFactory.newInstance();   
	    DocumentBuilder   builder = null;   
	    try {
	       builder= dbf.newDocumentBuilder();
	       doc=domReader.read(builder.parse(input));
	       input.close();
	    }catch (Exception ioe) {
	      
	    }
	    return doc;
	  }
	
	/**
     * 获得默认的开始与结束查询时间
     * @return 数组[开始时间,结束时间]
     */
    private String[] getDefaultStartAndEndTime()
    {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String endTime = sdf.format(c.getTime());
		
		c.add(Calendar.MONTH, -2);
		c.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));
		String startTime = sdf.format(c.getTime());
		
		String[] arr = new String[2];
		arr[0] = startTime;
		arr[1] = endTime;
		return arr;
    }
    
	private void keyChecker(String key) throws Exception{
		if(StringUtils.isEmpty(key)){
			throw new Exception("参数丢失");
		}
		String sKey = key.toLowerCase();
		if(sKey.contains(">") || sKey.contains("<") || sKey.contains("script")){
			throw new Exception("非法参数:"+sKey);
		}
	}
}
