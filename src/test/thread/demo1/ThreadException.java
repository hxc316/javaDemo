package test.thread.demo1;

import org.junit.Test;

public class ThreadException extends Thread{

	@Override
	public void run() {
		while(true){
			try{
				
				System.out.println(11122);
				Thread.sleep(100);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void test1(){
		new ThreadException().start();
	}
	
	public static void main(String[] args) {
		new ThreadException().start();
	}

}
