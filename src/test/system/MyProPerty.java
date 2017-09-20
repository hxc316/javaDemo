package test.system;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyProPerty {
	
	public static void main(String[] args) {
		System.setProperty("11","aa");
		System.setProperty("22", "bbb");
		System.setProperty("33", "ccc");
		Map<String, String> map = System.getenv();
		Properties properties = System.getProperties();
		
		Object pro_1 = properties.get("11");
		System.out.println(pro_1.toString());
		/*
		 * AppClassLoader 会负责加载该路径下面的class
		 */
		String s = System.getProperty("java.class.path");
		
		String encoding = System.getProperty("file.encoding");
		System.out.println("-------编码："+encoding);
		System.out.println("-------java.class.path----"+s); 
		Set<String> key = map.keySet();
		for(String k:key){
			String kValue = map.get(k);
			System.out.print(k+":");System.out.println(kValue);
		}
	}

}
