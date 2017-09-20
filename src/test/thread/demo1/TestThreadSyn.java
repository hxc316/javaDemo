package test.thread.demo1;
/**
 * 
 * @author Administrator
 * 当需要另外一个线程执行完 ，主线程才能执行。
 */
public class TestThreadSyn {
	protected static Object ob = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("begin test");
		Thread thread2 = new Thread(new ThreadT(),"aa");
//		ThreadT thread1 = new ThreadT();
//		thread1.run();
		thread2.start();
		Thread.currentThread().sleep(100);
		synchronized (ob) {
			System.out.println("end test");
		}
	}
}



class ThreadT implements Runnable{

	@Override
	public void run() {
		Thread.currentThread();
		synchronized(TestThreadSyn.ob){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("result is out");
		}
	}
}