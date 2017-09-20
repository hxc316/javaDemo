package thread.demo5.copy;

public class Copier{

	public String name;
	
	public Copier(String name){
		this.name = name;
	}
	
	public synchronized void copyPages(int pages){
		int  time = 1000 * pages;
		System.out.println(this.name + "打印机开始打印文件");
		try {
			Thread.currentThread().sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + "打印机打印文件完毕");
	}
	
}
