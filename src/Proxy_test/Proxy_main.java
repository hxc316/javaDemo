package Proxy_test;

import Proxy_test.impl.MyCrudBoImpl;

public class Proxy_main {
	

	public static void main(String[] args) {
		PermissionProxy proxy = new PermissionProxy();
		
		MyCrudBo be_proxy = (MyCrudBo) proxy.createProxy(new MyCrudBoImpl());
		
		be_proxy.saveUser();
	}
}
