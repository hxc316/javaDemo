package thread.demo4;

public class  Sample {
	
	//public static Object lock = new Object(); 

	int a = 1;
	int b = 2;

	 void  btoa(){
			 a = b;
	}
	
	 void atob(){
			 b = a;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				Sample sam = new Sample();
				sam.btoa();				// b 赋值给 a
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread1 a:" + sam.a +"; b:"+sam.b);
			}
		};
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				Sample sam = new Sample();
				sam.atob();		// a 赋值给b 
				System.out.println("a:" + sam.a +"; b:"+sam.b);
			}
		};
		
		Thread thread3 = new Thread(){
			@Override
			public void run() {
				Sample sam = new Sample();
//				sam.atob();		// a 赋值给b 
				System.out.println("thread3 a:" + sam.a +"; b:"+sam.b);
			}
		};
		
		thread1.start();
//		thread2.start();
		Thread.currentThread().sleep(99);
		thread3.start();
	}
}
