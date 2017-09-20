package thread.demo6;

public class DoCrud {
	
	public void sch(){
		synchronized (this) {
			System.out.println("开始查数据");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("查询完毕");
		}
	}

	public void upd(){
		synchronized (this) {
			System.out.println("开始跟新数据");
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("跟新数据完毕");
		}
	}
}
