package test.spring.Bean.demo1;

import java.lang.reflect.Method;
/**
 * 
 * date: 2011-7-16
 * author：huxinchao
 * 功能：反射的调用
 *
 */
public class MainRef {
	
	public static String beanName = "spring.Bean.demo1.ClassA";
	
	public static void main(String[] args) {
		Class<Object> classA = null;
		try {
			classA = (Class<Object>) Class.forName(beanName);
			Method met = classA.getMethod("setName",new Class[]{String.class});
			Object obj = classA.newInstance();
			met.invoke(obj, new String[]{"hxc"});
			ClassA clas = (ClassA) obj;
			System.out.println("name is : "+clas.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
