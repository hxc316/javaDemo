package test.staticBlockDemo;

public class InnerStaticClass {
	
	
	public void outStr(){
		System.out.println("do method outStr");
	}
	
	static class inner{
		public inner() {
			System.out.println("inner class method");
		} 
	}

	public static void main(String[] args) {
		InnerStaticClass staticTest = new InnerStaticClass();
		InnerStaticClass.inner inner = new inner();
		staticTest.outStr();
	}
}
