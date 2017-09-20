package test.block;

public class ClassA {
	
	public static void exeClassA(ClassA_A a){
		a.outA_a();
	}

	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassA_A a_a1 = new ClassA_A();
		ClassA_A a_a = new ClassA_A();
		a.exeClassA(a_a);
		ClassA.exeClassA(a_a1);//结果是 2  公用了static类型的 a_a 变量。
	}
	
}


class ClassA_A{
	
	public static int a_a = 0;
	
	public void outA_a(){
		a_a++;
		System.out.println(a_a);
	}
}