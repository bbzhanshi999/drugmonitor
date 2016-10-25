package com.simlink.task.common;



/**
 * 泛型结果类<br>
 * 可返回指定类型的结果
 * 
 * @author 
 * @param <T>
 */
public class GenericResult<T> extends Result {

    private static final long serialVersionUID = 6884388024939222192L;

    /** 结果对象 */
    protected T data;

    /**
     * 获取结果对象
     * @return 结果对象
     */
	public T getData() {
		return data;
	}
	 /**
     * 设置结果对象
     * @param object 结果对象
     */
	public void setData(T data) {
		this.data = data;
	}
    
    

}
