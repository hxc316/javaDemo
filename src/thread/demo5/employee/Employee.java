package thread.demo5.employee;

import thread.demo5.copy.Copier;

public class Employee extends Thread {

	private Copier copier;
	private String name;
	private int times;
	
	public Employee(String name,Copier copier,int times) {
		this.name = name;
		this.copier = copier;
		this.times = times;
	}

	@Override
	public void run() {
		System.out.println(name+"开始工作...");
		for(int i= 0;i<times;i++){
			int pageCount = (int)(Math.random())*5 + 1;
			copier.copyPages(pageCount);
		}
		System.out.println(name + "完成了工作 ");
	}
	
	public static void main(String[] args) {
		System.out.println(11);
		Copier copier = new Copier("夏普");
		Employee ep = new Employee("小A",copier, 2);
		ep.start();
		
		Copier copier1 = new Copier("佳能");
		Employee ep1 = new Employee("2B", copier, 2);
		ep1.start();
	}
}
