package test.annotation.exchanger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import test.annotation.inter.Label;
import test.annotation.pojo.AdData;

public class JxlDataChange {

	public static void toJxlObject(Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		Method methods[] = target.getClass().getMethods();
		Method arr$[] = methods;
		int len$ = arr$.length;
		
		
		for (int i$ = 0; i$ < len$; i$++) {
			Method method = arr$[i$];
			//test.annotation.inter
			if(method.isAnnotationPresent(test.annotation.inter.Label.class)){
				Object value = method.invoke(target, new Object[0]);
				Label annotations = method.getAnnotation(test.annotation.inter.Label.class);
				int index = annotations.colIndex();
				System.out.println("index ---- "+ index);
//				System.out.println("");
				System.out.println("-------------------" + value);
//				new label
				
			}
		}
	}
	
	public static void main(String[] args) {
		AdData data = new AdData();
		data.setAdName("sss11111");
		
		try {
			JxlDataChange.toJxlObject(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
