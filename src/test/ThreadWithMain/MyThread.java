package test.ThreadWithMain;

class MyThread implements Runnable {
	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(3000);
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}