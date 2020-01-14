package com.hyq.common;

import java.util.HashMap;

public class Result {
	/**
	 * code
	 */
	public final static String CODE = "code";

	/**
	 * data
	 */
	public final static String DATA = "data";

	/**
	 * 操作成功code
	 */
	public final static String SUCCESS_CODE = "0";

	/**
	 * 操作失败code
	 */
	public final static String FAIL_CODE = "-1";


	private String code;
	private Object data;


	public Result(String code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static Result ok(Object data){
		return new Result("0",data==null?new HashMap():data);
	}
	public static  Result fail(Object data){
		return new Result("-1",data==null?new HashMap():data);
	}


}
