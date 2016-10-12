package com.simlink.task.common;



/**
 * 返回结果类
* @ClassName: ResultConst 
* @Description: 回调结果码 
* @author  
* @date 2016年2月17日 下午5:29:48 
*
 */
public class ResultConst {
	
	@Description("后台校验[validateInterceptor] model返回KEY")
	public final static String ERROR_KEY_MODEL = "ERROR_KEY_MODEL";
	
	@Description("后台校验[validateInterceptor] request返回KEY")
	public final static String ERROR_KEY_REQUEST = "ERROR_KEY_REQUEST";
	
	@Description("页面验证码校验KEY")
	public final static String VERIFICATION_CODE_SESSION_KEY = "VERIFICATION_CODE_KEY";
	
	@Description("页面验证码返回提示信息KEY")
	public final static String VERIFICATION_CODE_RESULT_MSG_KEY = "VERIFICATION_CODE_RESULT_MSG_KEY";
	
	@Description("页面验证码返回提示信息")
	public final static String VERIFICATION_CODE_RESULT_MSG = "验证码输入有误";
	
	@Description("接口请求返回正常状态码")
	public final static String SUCCESS_CODE = "1";
	
	@Description("接口请求返回错误异常码")
	public final static String ERROR_CODE = "-1";
	
}
