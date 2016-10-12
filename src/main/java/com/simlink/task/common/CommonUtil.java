package com.simlink.task.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.w3c.dom.Element;



/**
 * 工具类
 * 
 * User: wxw Date: 2007-5-14 Time: 17:10:48 To change this template use File |
 * @modify donggf 
 */
@SuppressWarnings("unchecked")
public class CommonUtil {

	private static Log log = LogFactory.getLog(CommonUtil.class.getName());
	
	/**
	 * 把日期字符串转化成日期对象
	 * 
	 * @param strDate
	 * @return  date
	 */
	public static Date parseDate(String strDate) {
		String splitSign = "";
		if (strDate == null)
			return new Date();
		if (strDate.length() < 8 || strDate.length() > 10)
			throw new java.lang.IllegalArgumentException("Wrong Date Format [ "
					+ strDate + " ]");
		String[] splitSignArray = new String[] { "/", "\\", "-", "," };
		for (int i = 0; i < splitSignArray.length; i++)
			if (strDate.indexOf(splitSignArray[i]) > 0) {
				splitSign = splitSignArray[i];
			}
		String format = "yyyy" + splitSign + "MM" + splitSign + "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + strDate
					+ " ]");
		}
	}

	/**
	 * 把日期字符串转化成日期对象<code>java.util.Date</code>
	 * 
	 * @param strDate
	 * @return date
	 */
	public static Date parseDateTime(String strDate) {
		String splitSign = "";
		if (strDate == null)
			return new Date();
		String[] splitSignArray = new String[] { "/", "\\", "-", "," };
		for (int i = 0; i < splitSignArray.length; i++)
			if (strDate.indexOf(splitSignArray[i]) > 0) {
				splitSign = splitSignArray[i];
			}
		String format = "yyyy" + splitSign + "MM" + splitSign + "dd" + "HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + strDate
					+ " ]");
		}
	}

	/**
	 * 格式化时间
	 * @param tim
	 * @return 
	 * @author donggf 2008-4-6
	 */
	public static String formatTim(Date tim)
	{		
		return (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")).format(tim);
	}
	
    /**
	 * 转化成日期对象
	 *
	 * @param da
	 * @param format
	 * @return date
	 */
	public static Date formatDat(String da, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(da);
		} catch (Exception e) {
			throw new IllegalArgumentException("Wrong Date Format [ " + da
					+ " ]");
		}
	}
	
	/**
	 * 转化成日期对象
	 * 
	 * @param da
	 * @param format
	 * @return date
	 */
	public static String formatDate(Date da, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			if(da != null && !"".equals(da)) {
				return sdf.format(da);
			}
			return null;
		} catch (Exception e) {
			
			throw new IllegalArgumentException("Wrong Date Format [ " + da
					+ " ]");
		}
	}

    /**
	 * 转化成日期对象
	 *
	 * @param da
	 * @param format
	 * @return date
	 */
	public static String formatDate(String da, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.format(sdf.parse(da));
		} catch (Exception e) {
			try
			{
				return CommonUtil.parseUSDate(da, format);
			}catch(Exception en)
			{
				throw new IllegalArgumentException("Wrong Date Format ["+da+"]");
			}
		}
	}
	
	/**
	 * 转换英文格式的日期
	 * 
	 * @param inPutStr
	 * @return
	 * modify zhangliang
	 * describe: 去掉时区设置 2008-8-1
	 */
	public static String parseUSDate(String inPutStr, String myformat)
	{
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		Date parseDate = null;
		try {
			parseDate = format.parse(inPutStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat formatOut = new SimpleDateFormat(myformat);
		//不需要时区设置 
		//formatOut.setTimeZone(TimeZone.getTimeZone("GMT"));
		return formatOut.format(parseDate);		
	}

    /**
	 * 获得当前日期 yyyy:mm:dd
	 */
	public static java.sql.Date getCurDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}

    /**
	 * 获得当前日期 yyyy:mm:dd hh:mm:ss
	 */
	public static java.sql.Timestamp getCurTime() {
		return  new java.sql.Timestamp(new java.util.Date().getTime());
	}

	/**
	 * 将字符串转换为 Integer ，空字符串转为 0
	 * @param str
	 * @return Integer
	 */
	public static Integer getInteger(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return new Integer(0);
		} else {
			return new Integer(str);
		}
	}

	/**
	 * 将object转换为 Integer ，空字符串转为 0
	 * @param obj
	 * @return Integer
	 */
	public static Integer getInteger(Object obj) {
		try {
			String str = obj.toString();

			return new Integer(str);

		} catch (Exception e) {
			return new Integer(0);
		}
	}

	/**
	 * 将 null 转化为 ""
	 * @param str
	 * @return String
	 */
	public static String checkNull(String str) {
		if (str == null || "null".equals(str)) {
			return "";
		} else {
			return str;
		}

	}

	/**
	 * 检查是否为整型
	 * @param str
	 * @return boolean
	 */
	public static boolean checkInt(String str) {
		try {
			new Integer(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 将 null 转化为 ""
	 * @param obj
	 * @return String
	 */
	public static String checkNull(Object obj) {
		if (obj == null || "null".equals(obj.toString())) {
			return "";
		} else {
			
			return obj.toString();
		}
	}

	/**
	 * 判断字符是否为空
	 * @param str
	 * @return true false
	 */
	public static boolean isNull(String str) {
		if (str == null || "".equals(str.trim()) ||"null".equals(str) )
			return true;
		else
			return false;
	}
	
	/**
	 * 判断对象是否为空
	 * @param str
	 * @return true false
	 */
	public static boolean isNull(Object obj){
		if(null==obj)
		{
			return true;
		}else
		{
			return false;
		}
	}

	/**
	 * 对字符串进行 gb2312 转码，主要用于中文处理
	 * @param str
	 * @return String
	 */
	public static String parseGB2312(String str) {
/*		String newStr = null;

		try {
			newStr = new String(str.getBytes("ISO-8859-1"), "GB2312");
		} catch (Exception e) {
		}

		return newStr;*/
		return str;
	}
	
	/**
	 * 编码重解(websphere 使用)
	 * @param str
	 * @return
	 */
	public static String decode(String str){
		String s = "";
		try {
			s = java.net.URLDecoder.decode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		return s;
	}	

	/**
	 * 为字符串补足前导'0'
	 * 
	 * @param input
	 *            需要加'0'的字符串
	 * @param length
	 *            补"0"后字符串的长度
	 * @return 补足前导'0'的字符串 例如:addZero("04", 4),返回"0004"
	 */
	public static String addZero(String input, int length) {
		int inputLength = input.length();
		if (inputLength == length) {
			return input;
		} else if (inputLength < length) {
			for (int i = 0; i < length - inputLength; i++) {
				input = "0" + input;
			}
		}
		if (inputLength > length) {
			input = input.substring(0, length);
		}
		return input;
	}

	/**
	 * 根据日期计算病人的年龄
	 * @param oBirthDay
	 * @return int (年龄)
	 */

	public static int getAge(Date oBirthDay) {
		int iAge;
		Calendar oCalendarToday = Calendar.getInstance();
		oCalendarToday.setTime(new java.util.Date());

		Calendar oCalendarBirthday = Calendar.getInstance();
		oCalendarBirthday.setTime(oBirthDay);

		Calendar oCalendarTemp = Calendar.getInstance();
		oCalendarTemp.set(oCalendarToday.get(Calendar.YEAR), oCalendarBirthday
				.get(Calendar.MONTH), oCalendarBirthday.get(Calendar.DATE));

		iAge = oCalendarToday.get(Calendar.YEAR)
				- oCalendarBirthday.get(Calendar.YEAR);
		if (!oCalendarToday.after(oCalendarTemp)) {
			iAge--;
		}
		return iAge + 1;
	}

	public static String getValueFromSelectKey(HashMap Select, int key) {

		return "";
	}

	/**
	 * 将字符串转换为 Integer ，空字符串转为 null
	 * @param str
	 * @return Integer
	 */
	public static Integer getInte(String str) {
		if (str == null || "".equals(str)) {
			return null;
		} else {
			try {

				return new Integer(str);

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 将字符串解析为int ,null 转为 0
	 * 
	 * @param str
	 * @return   int
	 */
	public static int parseInt(String str) {
		try {
			Integer inte = new Integer(str);
			return inte.intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 将字符串转换为 Float ，空字符串转为 null
	 * 
	 * @param str
	 * @return Integer
	 */
	public static Float getFloat(String str) {
		if (str == null || "".equals(str)) {
			return null;
		} else {
			try {
				return new Float(str);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
        
	/**
	 * 运行指定方法名的方法(此处特指 pojo 类的 getXX() 方法)
	 * 
	 * @param obj
	 * @param className
	 * @return Object
	 */
	public static Object runMethod(Object obj, String fieldNam)
	{
		try
		{
			String firstChar = fieldNam.substring(0, 1).toUpperCase();
			String methodNam = "get" + firstChar + fieldNam.substring(1);

			Class cls = obj.getClass();
			Method method = cls.getDeclaredMethod(methodNam, new Class[0]);
			return method.invoke(obj, new Object[0]);
			
		}catch(Exception e)
		{
			//e.printStackTrace();
			return null;
		}
	}

	
	/*
	 * 时间转化
	 */
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat dateFormat_cn=new SimpleDateFormat("yyyy年MM月dd日");

	public static String dateFormat(Date date) {
		return (date == null) ? null : dateFormat.format(date);
	}

	public static String dateFormatCN(Date date){
		return (date == null) ? null : dateFormat_cn.format(date);
	}
	
	
	static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static String dateTimeFormat(Date date) {
		return (date == null) ? null : dateTimeFormat.format(date);
	}

	public static Date dateTimeFormat_old(String str) {
		try {
			return (str == null || str == "") ? null : dateTimeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date dateFormat_old(String str) {
		try {
			return (str == null || str == "") ? null : dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static Date dateFormat(String str) {
		try {
			return CommonUtil.isNull(str) ? null : dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date datetimeFormat(String str) {
		try {
			return CommonUtil.isNull(str) ? null : dateTimeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	static SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String timeFormat(Date date) {
		return (date == null) ? null : timeFormat.format(date);
	}
	
	public static Date timeFormat(String str) {
		try {
			return (str == null || str == "") ? null : timeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/***
	 * 一个完整的日期转换，从字符串转换成日期date类型
	 * @author wyj
	 * @date 20120830
	 * @param str
	 * @return
	 */
	public static Date fullDateFormat(String str) {
		try {
			return (str == null || str == "") ? null : fullFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * 一个完整的日期转换，从日期date转换成字符串类型
	 * @author wyj
	 * @date 20120830
	 * @param str
	 * @return
	 */
	public static String fullDateFormat(Date str){
		try {
			return (str == null) ? null : fullFormat.format(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过年龄得到出生日期(只算年数)
	 * @param age
	 * @return String
	 */
	public static String getCsrq(int age) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -age);
		return dateFormat(cal.getTime());
	}
	
	/**
     * 字符串编码转换
     * 
     * @param str
     * @return
     * @tzhli
     * @Time 2007-09-13
     */
    public static String characterEncodingChange(String str) {
    	String name = null;
    	try {
			name = new String(str.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return name;
    }

    /**
     * 通过出生日期获取年龄
     * 
     * @param born
     * @return String 年龄
     */
    public static String getAgeByBorn(String born) {
    	String nl = "";
    	
    	String[] nowDate = dateFormat(new Date()).split("-");
    	Integer nowYear = Integer.parseInt(nowDate[0]);
    	Integer nowMonth = Integer.parseInt(nowDate[1]);
    	Integer nowDay = Integer.parseInt(nowDate[2]);
    	
    	String[] bornDate = born.split("-");
    	Integer bornYear = Integer.parseInt(bornDate[0]);
    	Integer bornMonth = Integer.parseInt(bornDate[1]);
    	Integer bornDay = Integer.parseInt(bornDate[2]);
    		
    	Integer totalMonth = (nowYear - bornYear) * 12;
    	if(nowMonth > bornMonth)
    		totalMonth += (nowMonth - bornMonth);
    	else if(nowMonth < bornMonth)
    		totalMonth -= (bornMonth - nowMonth);
    	
    	Integer spareBornDay = 0;

    	Integer[] TheBornDay={31,28,31,30,31,30,31,31,30,31,30,31};
    	Integer[] TheNowDay={31,28,31,30,31,30,31,31,30,31,30,31};
    	if(bornYear % 4 == 0 && bornYear % 100 != 0 || bornYear % 400 == 0) {
    		TheBornDay[1]++;
    		TheNowDay[1]++;
    	}
    	spareBornDay = TheBornDay[bornMonth -1] - bornDay;
    	
    	if(totalMonth > 24) {
    		nl = String.valueOf(totalMonth / 12) + "岁";
    	} else if(totalMonth <= 24 && totalMonth >1) {
    		if(bornDay > nowDay)
    			nl = String.valueOf(totalMonth - 1) + "月";
    		else if(bornDay < nowDay && totalMonth == 24)
    			nl = String.valueOf(totalMonth / 12) + "岁";
    		else if(bornDay == nowDay)
    			nl = String.valueOf(totalMonth) + "月";
    	} else if(totalMonth == 1) {
    		nl = String.valueOf(spareBornDay + nowDay) + "天";
    	} else if(totalMonth == 0) {
    		nl = String.valueOf(nowDay - bornDay) + "天";
    	}
    	return nl;
    }
    
    
    
	
    /**
     * 用于获得不含包名的类名和字段名
     * @param str
     * @return String
     */
    public static String getLastNam(String fullNam)
    {
    	String[] arr = fullNam.split("\\.");
    	return arr[arr.length-1];
    }
    
    
    /**
     * 通过出生日和死亡日期获取年龄
     * 
     * @return String 年龄
     */
    public static String getAgeByBornAndDead(Date bornDateTime,Date deadDateTime) {
    	String nl = "";
    	
    	String[] deadDate = dateFormat(deadDateTime).split("-");
    	Integer deadYear = Integer.parseInt(deadDate[0]);
    	Integer deadMonth = Integer.parseInt(deadDate[1]);
    	Integer deadDay = Integer.parseInt(deadDate[2]);
    	
    	String[] bornDate = dateFormat(bornDateTime).split("-");
    	Integer bornYear = Integer.parseInt(bornDate[0]);
    	Integer bornMonth = Integer.parseInt(bornDate[1]);
    	Integer bornDay = Integer.parseInt(bornDate[2]);
    		
    	Integer totalMonth = (deadYear - bornYear) * 12;
    	if(deadMonth > bornMonth)
    		totalMonth += (deadMonth - bornMonth);
    	else if(deadMonth < bornMonth)
    		totalMonth -= (bornMonth - deadMonth);
    	
    	Integer spareBornDay = 0;

    	Integer[] TheBornDay={31,28,31,30,31,30,31,31,30,31,30,31};
    	Integer[] TheNowDay={31,28,31,30,31,30,31,31,30,31,30,31};
    	if(bornYear % 4 == 0 && bornYear % 100 != 0 || bornYear % 400 == 0) {
    		TheBornDay[1]++;
    		TheNowDay[1]++;
    	}
    	spareBornDay = TheBornDay[bornMonth -1] - bornDay;
    	
    	if(totalMonth >12) {
    		if(bornDay <deadDay)
    				nl = String.valueOf(totalMonth / 12) + "岁"+totalMonth%12+"月"+(deadDay - bornDay) + "天";
    		else if(bornDay >deadDay)
    				nl = String.valueOf(totalMonth / 12) + "岁"+totalMonth%12+"月"+(spareBornDay + deadDay) + "天";
    		else
    				nl = String.valueOf(totalMonth / 12) + "岁"+totalMonth%12+"月";
    	}
    	if(totalMonth ==12) {
    		nl = String.valueOf(totalMonth / 12) + "岁"+(deadDay - bornDay) + "天";
    	}
    	else if(totalMonth <12 && totalMonth >0) {
    		if(bornDay > deadDay && totalMonth>1)
    			nl = String.valueOf(totalMonth - 1) + "月"+(spareBornDay + deadDay) + "天";
    		if(bornDay > deadDay && totalMonth==1)
    			nl = (spareBornDay + deadDay) + "天";
    		else if(bornDay < deadDay)
    			nl = totalMonth  + "月"+(deadDay - bornDay) + "天";
    		else if(bornDay == deadDay)
    			nl = String.valueOf(totalMonth) + "月";
    	} 
    	else if(totalMonth == 0) {
    		nl = String.valueOf(deadDay - bornDay) + "天";
    	}
    	return nl;
    }
    
    /**
     * 根据指定类型计算两个日期相差的时间<br>
     * eg. dateDiff(birth, today, Calendar.MONTH) 孩子的月龄
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @param diffType 日期类型
     * @return 根据 diffType计算的 eDate - sDate 时差
     * @author zhangliang
     */
    public static Long dateDiff(Date sDate, Date eDate, int diffType)
    {
    	long diffMill = eDate.getTime() - sDate.getTime();
		long rtn = 0;
		switch(diffType)
		{
			case Calendar.MILLISECOND: rtn = diffMill;break;
			case Calendar.SECOND: rtn = diffMill / 1000; break;
			case Calendar.MINUTE: rtn = diffMill / 1000 / 60; break;
			case Calendar.HOUR :  rtn = diffMill / 1000 / 3600; break;
			case Calendar.DATE: rtn = diffMill / 1000 / 60 / 60 / 24; break;
			case Calendar.MONTH: rtn = diffMill / 1000 / 60 / 60 / 24 / 12;break;
			case Calendar.YEAR : rtn = diffMill / 1000 / 60 / 60 / 24 / 365;break;
		}
		return rtn;
    }
    
    
    /**
     * 根据指定类型计算两个日期相差的时间<br>
     * eg. dateDiff(birth, today, Calendar.MONTH) 孩子的月龄
     * @param sDate 开始时间
     * @param eDate 结束时间
     * @param diffType 日期类型
     * @return 根据 diffType计算的 eDate - sDate 时差
     * @author zhangliang
     */
    public static Boolean dateDiffDay(Date sDate, Date eDate)
    {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String startDate = sdf.format(sDate);
        
        String endDate = sdf.format(eDate);
        
        if (startDate.equals(endDate))
        {
            return true;
        }
        
        return false;
    }
    
    
	/**
     *  
	 * 根据生日算实足年龄
	 * 算法:
	 * 年龄：能够按照出生日期自动计算，不足1个月显示日龄，
	 * 不足1岁显示月龄+日龄，不足5岁显示年龄+月龄
     * 
     * @return String 年龄
     */
    public static String getActualAge(Date birthDay) {
    	if(getCurDate().compareTo(birthDay) <= 0){
    		return "";
    	}
    	String nl = "";
    	String[] deadDate = CommonUtil.dateFormat(CommonUtil.getCurDate()).split("-");
    	Integer deadYear = Integer.parseInt(deadDate[0]);
    	Integer deadMonth = Integer.parseInt(deadDate[1]);
    	Integer deadDay = Integer.parseInt(deadDate[2]);
    	
    	String[] bornDate = CommonUtil.dateFormat(birthDay).split("-");
    	Integer bornYear = Integer.parseInt(bornDate[0]);
    	Integer bornMonth = Integer.parseInt(bornDate[1]);
    	Integer bornDay = Integer.parseInt(bornDate[2]);
    		
    	Integer totalMonth = (deadYear - bornYear) * 12;
    	if(deadMonth > bornMonth)
    		totalMonth += (deadMonth - bornMonth);
    	else if(deadMonth < bornMonth)
    		totalMonth -= (bornMonth - deadMonth);
    	
    	Integer spareBornDay = 0;

    	Integer[] TheBornDay={31,28,31,30,31,30,31,31,30,31,30,31};
    	Integer[] TheNowDay={31,28,31,30,31,30,31,31,30,31,30,31};
    	if(bornYear % 4 == 0 && bornYear % 100 != 0 || bornYear % 400 == 0) {
    		TheBornDay[1]++;
    		TheNowDay[1]++;
    	}
    	spareBornDay = TheBornDay[bornMonth -1] - bornDay;
    	
    	if(totalMonth >=60){
    		nl = String.valueOf(totalMonth / 12) + "岁";
    	}else 	if(totalMonth >12) {
    		nl = String.valueOf(totalMonth / 12) + "岁"+totalMonth%12+"个月";
    	}
    	if(totalMonth ==12) {
    		nl = String.valueOf(totalMonth / 12) + "岁"+(deadDay - bornDay + 1) + "天";
    	}
    	else if(totalMonth <12 && totalMonth >0) {
    		if(bornDay > deadDay && totalMonth>1)
    			nl = String.valueOf(totalMonth - 1) + "个月"+(spareBornDay + deadDay + 1) + "天";
    		if(bornDay > deadDay && totalMonth==1)
    			nl = (spareBornDay + deadDay + 1) + "天";
    		else if(bornDay < deadDay)
    			nl = totalMonth  + "个月"+(deadDay - bornDay + 1) + "天";
    		else if(bornDay == deadDay)
    			nl = String.valueOf(totalMonth) + "个月";
    	} 
    	else if(totalMonth == 0) {
    		nl = String.valueOf(deadDay - bornDay + 1) + "天";
    	}
    	return nl;
    }
    
    /**
     * 将一个字符串转换为DB2的TimeStramp要求
     * @param date
     * @return
     * @time: 2008-9-23
     * @author: yukunhua	
     */
    public static String date2TimeStamp(String date){
    	String [] str = date.split(" ");
    	int len = date.indexOf(":");
    	if(str.length<2 && len == -1){
    		return str[0] +" "+ "00:00:00";
    	}else if(str.length == 2){
    		String [] sfmArr = str[1].split(":");
    		if(sfmArr.length == 1){
    			return str[0] + " " +str[1]+":00:00";
    		}else if(sfmArr.length == 2){
    			return str[0] + " " + str[1] + ":00";
    		}else if(sfmArr.length == 3){
    			return date;
    		}
    	}
    	return "格式错误！";
    }
    
	/**
	 * 读取 xml 数据
	 * @param request
	 * @return
	 */
	public static String readXMLFromRequest(HttpServletRequest request) {
		StringBuffer xml   =  new StringBuffer();
		String       line  =  null ;
		try{
		    BufferedReader reader  =  request.getReader();
		    while((line = reader.readLine())!= null ){
		        xml.append(line);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return  xml.toString();
    } 
	
    /**
     * 判断给定的字符串是否为纯数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
    	if (str == null) {
    		return false;
    	}
    	/** 出于效率上的考虑，这里使用Possessive数量词 */
    	return Pattern.compile("\\d++").matcher(str).matches();
    }
	
    /**
     * 毫秒转换成时间
     *
     * @param timeInSeconds 毫秒
     */
    public static double getSubHours(long timeInSeconds) {
        long hours, minutes, seconds;
        hours = timeInSeconds / 3600000;
        timeInSeconds = timeInSeconds - (hours * 3600000);
        minutes = timeInSeconds / 60000;
        timeInSeconds = timeInSeconds - (minutes * 60000);
        seconds = timeInSeconds / 1000;
        double d_hours = hours;
        double d_minutes = minutes;
        return d_hours+ d_minutes/60;
    }
    
    
    /**
     * 时间加上小时后的时间
     * @param tmpTime
     * @param hours
     * @return
     */
    public static Date dateAdd_d(Date tmpTime, int hours) {
        if(tmpTime==null)
        {
            return tmpTime;
        }
        Timestamp time = new Timestamp(tmpTime.getTime());
        Date date = new Date(time.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, hours);
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH) + 1;
        int date1 = c.get(Calendar.DATE);


        return parseDateTime(year1 + "-" + month1 + "-" + date1+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE));

    }
    
	public static String dateSub(Date source, Date dest) {
        String str="";
        if(source==null||dest==null)
        {
            return "";
        }
        if(source.getTime() - dest.getTime()<0)
        {
             str=calcHMS(dest.getTime()-source.getTime());
            str="超时 "+str;
        }else
        {
            str=calcHMS(source.getTime() - dest.getTime());
        }
        return str;
    }

    public static String dateSub_i(Date source, Date dest) {
        String str = "";
        if (source == null || dest == null) {
            return "0";
        }
       return String.valueOf(source.getTime() - dest.getTime());
    }
    
    /**
     * 毫秒转换成时间
     *
     * @param timeInSeconds 毫秒
     */
    public static String calcHMS(long timeInSeconds) {
        long hours, minutes, seconds;
        hours = timeInSeconds / 3600000;
        timeInSeconds = timeInSeconds - (hours * 3600000);
        minutes = timeInSeconds / 60000;
        timeInSeconds = timeInSeconds - (minutes * 60000);
        seconds = timeInSeconds;
        return hours + "小时" + minutes + "分钟";
    }

    /**
     * 时间加上小时后的时间
     *
     * @param tmpTime
     * @param month
     * @return
     */
    public static Date dateAdd_m(Date tmpTime, int month) {
        if (tmpTime == null) {
            return tmpTime;
        }
        Timestamp time = new Timestamp(tmpTime.getTime());
        Date date = new Date(time.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH) + 1;
        int date1 = c.get(Calendar.DATE);


        return parseDateTime(year1 + "-" + month1 + "-" + date1 + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));

    }
     /**
     * 时间加上小时后的时间的字符串表示
     * @param tmpTime
     * @param hours
     * @return
     */
    public static String dateAdd(Date tmpTime, int hours) {          
        return formatDate(dateAdd_d(tmpTime, hours), "yyyy-MM-dd HH:mm");

    }

    /**
     * 毫秒转换成时间
     *
     * @param timeInSeconds 毫秒
     */
    public static long getHours(long timeInSeconds) {
        long hours;
        hours = timeInSeconds / 3600000;
        return hours;
    }

    /**
     * 获取百分比
     *
     * @param p1
     * @param p2
     * @return
     */
    public static String percent(double p1, double p2) {
        String str;
        double p3 = p1 / p2;
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        str = nf.format(p3);
        return str;
    }

    /**
     * 返回 COOKIE 值
     * @param nam
     * @return
     */
    public static String getCookieVal(HttpServletRequest req, String nam)
    {
    	Cookie[] arr  = req.getCookies();
    	Cookie cookie = null;;
    	for(int i=0; i<arr.length; i++)
    	{
    		cookie = arr[i];
    		if(cookie.getName().equals(nam))
    		{
    			return cookie.getValue();
    		}
    	}
    	return null;
    }
    
	//释放资源
	public static void free(ResultSet rs, PreparedStatement pt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pt != null) {
						pt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (con != null) {
							con.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	
    /**
     * 诊断解码
     * @throws IOException 
     * 
     * */
	public static String[] decodeZdNam(String[] icdName) throws IOException{
		
		if(!CommonUtil.isNull(icdName))
		{
			Pattern p = Pattern.compile("%((\\w{0,2}\\d{0,2})|(\\d{0,2}\\w{0,2}))+%");
	        for(int i=0;i<icdName.length;i++){
	        	Matcher m = p.matcher(icdName[i]);
	        	if(m.find())
		        {
	        		try {
	        			icdName[i] = URLDecoder.decode(icdName[i], "UTF-8");
	        		} catch (UnsupportedEncodingException e) {
	        			return icdName;
	        		}
		        }
			}
		}
		
		return icdName;
	}

	
	
	
	/**
	 * 字符转换器  ISO 到 UTF-8
	 * @param str 需要转码的字符串
	 * @return String 转码后的字符串
	 * @throws UnsupportedEncodingException 
	 */
	public static String iso2utf8(String str) throws UnsupportedEncodingException {
		//String defaultCharsetName = Charset.defaultCharset().name();
		String newStr = new String(str.getBytes("iso-8859-1"), "UTF-8");
		return newStr;
	}
	
	
	public static String formatDateOracle(String strDate,int param)
    {
        String resut = null;
        if(param == 1)
        {
            //24小时制
            resut = "to_date('" + strDate + "','yyyy-mm-dd hh24:mi:ss')";
        }
        if(param == 2)
        {
            //12小时制
            resut = "to_date('" + strDate + "','yyyy-mm-dd hh:mi:ss')";
        }
        if(param == 3)
        {
            //年月日时分
            resut = "to_date('" + strDate + "','yyyy-mm-dd hh24:mi')";
        }
        return resut;
        
    }
	
	
	 public static String getNewDateStr()
	 {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        //System.out.println("Today is:"+sdf.format(Calendar.getInstance().getTime()));
	        return sdf.format(Calendar.getInstance().getTime());
	 }
	 
	 
	 public static String getDateStr(int i)
     {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR_OF_DAY, i);
            return sdf.format(cal.getTime());
     }
	 
	 
	 public static Date getNewDate()
     {
            return new Date();
     }
	 
	 public static String getNyDate()
	 {
	     String result = null;
         Calendar calendar = Calendar.getInstance();//获得的是当前的时间
         int year =calendar.get(Calendar.YEAR);
         int month=calendar.get(Calendar.MONTH)+1;
         int day =calendar.get(Calendar.DAY_OF_MONTH);
         if (month<10)
         {
             result = year+"-0"+month;
         }
         else
         {
             result = year+"-"+month;
         }
         if (day<10)
         {
             result = result +"-0"+day;
         }
         else
         {
             result = result +"-"+day;
         }
         return result;
	 }
	 
	 
	 public static String getHourDate()
     {
         Calendar calendar = Calendar.getInstance();//获得的是当前的时间
         int hour =calendar.get(Calendar.HOUR_OF_DAY);
         return String.valueOf(hour);
     }
	 
	 public static String getMinuteDate()
     {
         Calendar calendar = Calendar.getInstance();//获得的是当前的时间
         int minute =calendar.get(Calendar.MINUTE);
         return String.valueOf(minute);
     }
	 
	 
	 
	 
	 
	 
	
	 
	 
	 
     
    public static  String ObjectToString(Object o)
    {
        
        StringBuffer sb = new StringBuffer();
        
        try
        {
            // 得到类对象
            Class objcet = (Class)o.getClass();
            
            sb.append("对象名称:"+objcet.getName()+"----");
            
            /*
             * 得到类中的所有属性集合
             */
            Field[] fs = objcet.getDeclaredFields();
            for (int i = 0; i < fs.length; i++)
            {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                Object value = f.get(o); // 得到此属性的值
                
                //System.out.println("name:" + f.getName() + "/t value = " + value);
                
                String type = f.getType().toString(); // 得到此属性的类型
                
                sb.append("属性:" + f.getName() + "; 值:" + value + "; 类型:"+type +"; ");
            }
            /*
             * 得到类中的方法
             */
            /*Method[] methods = objcet.getMethods();
            for (int i = 0; i < methods.length; i++)
            {
                Method method = methods[i];
                if (method.getName().startsWith("get"))
                {
                    System.out.print("methodName:" + method.getName() + "/t");
                    
                    System.out.println("value:" + method.invoke(o,));
                }
            }*/
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        if (!CommonUtil.isNull(sb)&&!CommonUtil.isNull(sb.toString()))
        {
            return sb.toString();
        }
        return null;
    }
    
    
    
    public static Clob oracleStr2Clob(String str, Clob lob) throws Exception 
    {
        Method methodToInvoke = lob.getClass().getMethod("getCharacterOutputStream", (Class[])null);
        Writer writer = (Writer)methodToInvoke.invoke(lob, (Object[])null);
        writer.write(str);
        writer.close();
        return lob;
    } 
    
    
    public static  Integer getStartRow(String pageNumber,Integer pageSize) 
    {
        Integer startRow = 0;
        if (!CommonUtil.isNull(pageNumber)) {
            startRow = (Integer.parseInt(pageNumber) - 1) * pageSize;
        }
        return startRow;
    }
     
	 
	 public static void main(String[] a) throws ParseException
	 {
	    
	     
	     int beginYear = dateFormat.parse("2013-12-03").getYear();
	     int beginMonth = dateFormat.parse("2013-12-03").getMonth();

	     int endYear = dateFormat.parse("2014-02-13").getYear();
	     int endMonth = dateFormat.parse("2014-02-13").getMonth();

	     int difMonth = (endYear-beginYear)*12+(endMonth-beginMonth);
	     
	 } 
}