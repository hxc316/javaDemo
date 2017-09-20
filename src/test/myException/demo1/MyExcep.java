package test.myException.demo1;

public class MyExcep extends RuntimeException {

	public MyExcep(String msg){
		super(msg);
	}
	
	public MyExcep(String msg, Throwable cause){
		System.out.println("-------- myExcep:"+msg);
	}
}
