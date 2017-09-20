package thread.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class ThreadPool {
	
	public static void main(String[] args) {
		// 
		ExecutorService executor = Executors.newFixedThreadPool(200);
		for(int i = 0;i<10;i++){
			Runner run = new Runner(i);
			executor.execute(run);
		}
		executor.shutdown();
	}
}
