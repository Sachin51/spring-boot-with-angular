package com.learn.webservice.model;

public class HelloBean {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HelloBean(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloBean [msg=" + msg + "]";
	}
}
