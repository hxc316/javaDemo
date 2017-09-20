package thread.demo4.sleep;


class Thread1 extends Thread{
	@Override
	public void run() {
		try {
			Thread.currentThread();
			System.out.println("线程开始休眠---- 10 秒钟");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


public class SleepThread {
	public static void main(String[] args) {
		Thread1 th = new Thread1();
		th.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("打断线程: ");
		
		th.interrupt();	//interrupt 通过来取消阻塞操作
//		th.stop();
		System.out.println("线程是否还活跃:"+th.isAlive());
	}

}
 