package thread.customer.thread;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{

	public final BlockingQueue<String> quequ;
	
	public Customer(BlockingQueue<String> q){
		this.quequ = q;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<194;i++){
			try {
				System.out.println("customer "+ quequ.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
