package Proxy_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PermissionProxy  implements InvocationHandler {
	private Object _proxyObject;
	public Object createProxy(Object proxy_object){
		this._proxyObject = proxy_object;
		return Proxy.newProxyInstance(_proxyObject.getClass().getClassLoader(),_proxyObject.getClass().getInterfaces()
				, this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		MyCrudBo crudImpl = (MyCrudBo) this._proxyObject;
		if(crudImpl.getUser() != null){
			return method.invoke(proxy, args);
		}else{
			System.out.println("ÇëµÇÂ½ £¡");
			return null;
		}
	}
}
