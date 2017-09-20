package test.myException.demo2;

import test.myException.demo1.MyExcep;
import test.myException.demo1.MyNullException;

public class FinnallyException {

	@SuppressWarnings("finally")
	public void doStings(){
		try{
			throw new MyExcep("in try");
		}catch (MyExcep e) {
			System.out.println("捕捉到异常,处理掉");
		}finally{
			System.out.println("finally 这个我必须执行...");
			throw new MyNullException("我的异常在finally...");
		}
	}
	
	public static void main(String[] args) {
		FinnallyException finExe = new FinnallyException();
		try{
			finExe.doStings();
			System.out.println("NND 执行不到我了...");
		}catch (MyNullException e) {
			System.out.println("你抛出的null exception 被我捕捉了!");
		}
	}
}
