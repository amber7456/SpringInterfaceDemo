package com.domain;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int NO_PERMISSION = -1; // 允许; 批准，正式认可，认可
	private String msg = "success";
	private long code = SUCCESS;
	private T data;

	public ResultBean() {
		super();
	}

	public ResultBean(T data) {
		super();
		this.data = data;
	}

	public ResultBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultBean [msg=" + msg + ", code=" + code + ", data=" + data + "]";
	}

}
