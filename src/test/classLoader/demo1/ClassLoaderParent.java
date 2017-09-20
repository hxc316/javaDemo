package test.classLoader.demo1;

public class ClassLoaderParent {

	public static void main(String[] args) {
		// 我的类的加载器
		 System.out.println(ClassLoader.getSystemClassLoader());
		
	     System.out.println(ClassLoader.getSystemClassLoader().getParent());
	     System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	     
//	     System.out.println(ClassLoader.getBootstrapClassPath());
	     
	     String s = System.getProperty("java.class.path");
	     System.out.println(s);
	}
}
