package com.simlink.task.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.simlink.task.common.GenericResult;

/**
 * 项目通用的Controller类，留作扩展
 * @author Administrator
 *
 */
public class BasicController extends MultiActionController{
	
	private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

	protected void doResponse(HttpServletResponse response, String jsonStr){
		try {
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 构造返回报文
	 * @param parent
	 * @param status
	 * @param errorCode
	 * @param message
	 * @param validFeildResult
	 * @param args
	 * @param object
	 * @return
	 */
	protected Map<String, Object> createMap(String nodeName,GenericResult<Object> result) {
		Map<String, Object> nodeMap = new HashMap<String, Object>();
		nodeMap.put(nodeName, result);
		return nodeMap;
	}
	/**
	 * 返回接收到的xml字符串
	 * @param request
	 * @return
	 * @throws IOException
	 */
	protected String getRequestXml(HttpServletRequest request) throws IOException{
		ServletInputStream sis = request.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int read = 0;
		byte[] buffer = new byte[4096];
		while((read = sis.read(buffer)) > 0){
			baos.write(buffer, 0, read);
			baos.flush();
		}
		String xmlRequset = new String(baos.toByteArray(), "UTF-8");
		sis.close();
		baos.close();
		logger.info("请求报文:\n"+xmlRequset);
		if(StringUtils.isNotEmpty(xmlRequset)){
			return xmlRequset;
		}
		return null;
	}
	
}