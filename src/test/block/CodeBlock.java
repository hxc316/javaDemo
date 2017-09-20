package test.block;

public class CodeBlock {

	public static void main(String[] args) {
		Code code = new Code();
		code.getType();
	}
}

class Code{
	public Code(){
		
	}
//	static
	{
		System.out.println("this is block code");
	}
	public static void getValue(){
		System.out.println("this is value");
	}
	public void getType(){
		System.out.println("this is type");
	}
}
