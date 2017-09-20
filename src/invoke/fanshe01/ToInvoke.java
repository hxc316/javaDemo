package invoke.fanshe01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ToInvoke {
	
	public static void main(String[] args) throws ClassNotFoundException,
		SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class myClass = ToInvoke.class.getClassLoader().loadClass("invoke.fanshe01.MyClass");
		Object myObject = myClass.newInstance();
		Class paramTypes[] = new Class[1];
		paramTypes[0] = Class.forName("java.lang.String");
		Method method = myObject.getClass().getMethod("aa",paramTypes);
		System.out.println(method.getName());
		method.invoke(myObject, "111"); 
	}

}
