package test.classLoader.demo2;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {
	
	public static String DEAFAULTDIR = "d:\\"; 
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = null;
		try {
			b = loadClassData(FormatClassName(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return defineClass(name, b, 0, b.length);
	}

	public byte[] loadClassData(String fileName) throws IOException{
		int n = 0;
		BufferedInputStream buInput = new 
			BufferedInputStream(new FileInputStream(new File(fileName)));
		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
		while((n = buInput.read())!=-1){
			byteOutput.write(n);
		}
		buInput.close();
		return byteOutput.toByteArray();
	}
	/**
	 *  获取类的地址
	 * @param name
	 * @return
	 */
	 public static String FormatClassName(String name){
//		 	String DEAFAULTDIR = System.getProperty("java.class.path");
	        String FILEPATH= DEAFAULTDIR + name+".class";
	        return FILEPATH;
	    }
	 
	 public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoader classLoader = new MyClassLoader();
		classLoader.findClass("MyBean");
	}

}
