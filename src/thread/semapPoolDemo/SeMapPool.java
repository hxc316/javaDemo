package thread.semapPoolDemo;

import java.util.concurrent.Semaphore;

public class SeMapPool {

	private static final int MAX = 5;
	
	private final Semaphore available = new Semaphore(MAX);
	
	protected Object[] items = {"aa","bb","cc","dd","ee"};
	protected boolean[] used = new boolean[MAX];
	
	public static void main(String[] args) {
		
		/**
		 * 1，为什么很多地方都需要使用 finnal 
		 */
		
		final SeMapPool pool = new SeMapPool();
		Runnable runner = new Runnable() {
			@Override
			public void run(){
				Object o ;
				try {
					o = pool.getItems();
					System.out.println(Thread.currentThread().getName()+"acquire :"+o);
					Thread.sleep(1000);
					pool.putItem(o);
					System.out.println(Thread.currentThread().getName()+"release:"+o);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		for(int i=0;i<10;i++){
			new Thread(runner).start();
		}
		
	}
	
	public Object getItems() throws InterruptedException{
		available.acquire();	// 获取继续执行 
		return getItemsSyn();
	}
	
	public synchronized Object getItemsSyn(){
		for(int i=0;i<MAX;++i){
			if(!used[i]){
				used[i]= true;
				return items[i];
			}
		}
		return null;
	}
	
	public synchronized void  putItem(Object o){
		for(int i=0;i<MAX;i++){
			if(items[i] == o){
				if(used[i])
					used[i] = false;
			}
		}
		available.release();// 执行完毕 释放
	}
	
}
