package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReturnLockDemo1 implements Runnable{
	
	private Lock lock = new ReentrantLock();
	
	private Integer count = 0;
	
	/**
	 * 每个线程拷贝一份
	 * 线程之间相互不干扰
	 */
	private ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 0;
		}
		
	};

	@Override
	public void run() {
		add();
	}
	
	
	public void count(){
		for(int i=0;i<10;i++){
			seqNum.set(seqNum.get()+1);
			System.out.println(Thread.currentThread().getName()+":"+seqNum.get());;
		}
	}
	/**
	 * 用锁机制 
	 * 保证同时只有一个线程在执行以下代码
	 */
	public void add(){
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+":"+"begin 1 ");
			Thread.currentThread().sleep(100);
			System.out.println(Thread.currentThread().getName()+":"+"begin 2 ");
			Thread.currentThread().sleep(100);
			System.out.println(Thread.currentThread().getName()+":"+"begin 3 ");
			Thread.currentThread().sleep(100);
//			System.out.println(Thread.currentThread().getName()+count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lock.unlock();
	}
	
	
	public static void main(String[] args) {
		ReturnLockDemo1 demo1 = new ReturnLockDemo1();
//		ReturnLockDemo1 demo2 = new ReturnLockDemo1();
//		ReturnLockDemo1 demo3 = new ReturnLockDemo1();
		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();
		new Thread(demo1).start();
		
	}

}
