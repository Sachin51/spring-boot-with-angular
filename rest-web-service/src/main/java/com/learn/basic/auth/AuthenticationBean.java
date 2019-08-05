package com.learn.basic.auth;

public class AuthenticationBean {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public AuthenticationBean(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "AuthenticationBean [msg=" + msg + "]";
	}
}
