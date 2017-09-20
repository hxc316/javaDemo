package thread.doCode.joinTest;

public class JoinTest extends Thread{

	@Override
	public void run() {

		try {
			System.out.println("---次线程开始...");
			Thread.currentThread().sleep(4000);
			System.out.println("---次程序结束...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("主线程开始...");
		JoinTest joinT = new JoinTest();
		joinT.start();
		try {
//		    joinT.wait();
			joinT.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("主程序结束...");
	}
	

}
