package test.ThreadWithMain;

public class Demo1 {


	public static void main(String[] args) throws InterruptedException {
		MyThread thread = new MyThread();
		while(true){
			thread.run();
		}
	}
}
