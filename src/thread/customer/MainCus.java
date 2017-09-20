package thread.customer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import thread.customer.thread.Customer;
import thread.customer.thread.Producer;

public class MainCus {
	
	public static void main(String[] args) {
		/*
		 * 1,ArrayBlockingQueue 和 LinkBlockingQueue 差不多
		 */
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		
		Producer pro1 = new Producer(queue);
		Producer pro2 = new Producer(queue);
		
		Customer cus1 = new Customer(queue);
		new Thread(pro1).start();
		new Thread(pro2).start();
		new Thread(cus1).start();
	}

}
