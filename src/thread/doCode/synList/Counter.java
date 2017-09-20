package thread.doCode.synList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Counter {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CasCounter cou = new CasCounter();
		MyThread thread1 = new MyThread(cou);
		MyThread1 thread2 = new MyThread1(cou);
		executor.execute(thread1);
		executor.execute(thread2);
		
	}

}

class MyThread extends Thread {

	private CasCounter counter;

	public MyThread(CasCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			int value = counter.getValue();
//			value +=1;
//			counter.setValue(value);
			counter.add();
			System.out.println(Thread.currentThread().getName() + " : " +counter.getValue());
		}
	}
}

class MyThread1 extends Thread {

	private CasCounter counter;

	public MyThread1(CasCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter.remove();
			System.out.println(Thread.currentThread().getName() + " : " +counter.getValue());
		}
	}

}
// 
class CasCounter {

	private Integer value = 0;

	public synchronized Integer getValue() {
			return value;
	}
	
	public synchronized void add(){
	
		this.value = this.getValue() + 1;
	}
	public synchronized void remove(){
		
		this.value = this.getValue() - 1;
	}
}
