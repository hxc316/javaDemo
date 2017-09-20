package Proxy_test.impl;

import Proxy_test.MyCrudBo;

public class MyCrudBoImpl implements MyCrudBo{

	private String username;
	
	@Override
	public String getUser() {
		System.out.println("get a user");
		return null;
	}

	@Override
	public void saveUser() {
		System.out.println("save a user");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
