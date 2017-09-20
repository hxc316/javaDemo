package thread.demo1;

public class Runner implements Runnable{

	int index = 0;
	public Runner(int index){
		this.index = index;
	}
	
	@Override
	public void run() {
		long time = (long) (Math.random()*1000);
		Thread thread = Thread.currentThread();
		System.out.println("线程："+thread.getName() +":" +index +"休眠时间: "
				+ time);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
