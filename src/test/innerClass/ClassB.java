package test.innerClass;

public class ClassB {
	
	String name = "xiaoming";
	
	public void sayName(){
		name = "xiaohong";
		a.syso();
		
	}
	
	InterA a = new InterA() {
		@Override
		public void syso() {
			System.out.println("hello:" + name);
		}
	};

	
	public static void main(String[] args) {
		ClassB b = new ClassB();
		b.sayName();
	}
}
