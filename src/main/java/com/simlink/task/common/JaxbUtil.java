package com.simlink.task.common;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;
/** 
 * Jaxb2工具类 
 * @create      2016-9-30	
 */  
@Component
public class JaxbUtil {
	/** 
     * JavaBean转换成xml 
     * 默认编码UTF-8 
     * @param obj 
     * @param writer 
     * @return  
     */  
    public static String convertToXml(Object obj) {  
        return convertToXml(obj, "UTF-8");  
    }  
  
    /** 
     * JavaBean转换成xml 
     * @param obj 
     * @param encoding  
     * @return  
     */  
    public static String convertToXml(Object obj, String encoding) {  
        String result = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
            Marshaller marshaller = context.createMarshaller();  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
  
            StringWriter writer = new StringWriter();  
            marshaller.marshal(obj, writer);  
            result = writer.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return result;  
    }  
  
    /** 
     * xml转换成JavaBean 
     * @param xml 
     * @param c 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T converyToJavaBean(String xml, Class<T> c) {  
        T t = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(c);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            t = (T) unmarshaller.unmarshal(new StringReader(xml));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return t;  
    }  
    /**
	 * 接口返回值
	 * @param errorMsg 错误日志
	 * @param webDesc 链接描述
	 * @return
	 */
	public String setBackResult(String errorMsg,String webDesc) {  
        Document document = DocumentHelper.createDocument();  
        Element results = document.addElement("results");  
        Element WEBNAME = results.addElement("WEBNAME");  //接口名称  
        WEBNAME.addText(webDesc);         
        Element lastTime = results.addElement("lastTime");  //返回时间  
        lastTime.addText(CommonUtil.fullDateFormat(new Date()));  
        Element state = results.addElement("state");    //状态:1--成功    0--失败  
        if(StringUtils.isBlank(errorMsg)){  
            state.addText("1");  
        }else{  
            state.addText("0");  
        }  
        Element errorMsg1 = results.addElement("errorMsg");   //错误信息  
        errorMsg1.addText(errorMsg);  
        StringWriter sw = new StringWriter();  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        XMLWriter writer = new XMLWriter(sw, format);  
        try {  
            writer.write(document);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return sw.toString();  
    }
}
