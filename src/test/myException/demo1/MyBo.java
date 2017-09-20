package test.myException.demo1;

public class MyBo {
	
	public static void main(String[] args){
		MyBo bo = new MyBo();
		try {
			bo.doThings();
		} catch (RuntimeException e) {
			System.out.println("捕捉到了我的异常");
			e.printStackTrace();
		}
	}
	
	public void doThings(){
		System.out.println("do tings");
		throw new MyExcep("my Exception");
	}

}
