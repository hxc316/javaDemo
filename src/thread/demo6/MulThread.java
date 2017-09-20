package thread.demo6;

public class MulThread {
	
	public static void main(String[] args) {
		DoCrud crud = new DoCrud();
		DoThread thread1 = new DoThread(crud);
		DoUpdThread thread2 = new DoUpdThread(crud);
		thread1.start();
		thread2.start();
	}

}
