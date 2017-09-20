package thread.customer.thread;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private final BlockingQueue<String> quequ;
	public Producer(BlockingQueue<String> q){
		this.quequ = q;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++){
			try {
				quequ.put(produce());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	String produce(){
		String temp = ""+(char)('A'+(int)(Math.random()*26));
		System.out.println("procedu " + temp);
		return temp;
	}
}
