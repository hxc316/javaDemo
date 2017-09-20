package designed.callback;

public class CallbackTest {
	private CallBackInter callback;
	
	public static void main(String[] args) {
		
	}
	
	public void doSucess(CallBackInter call){
		System.out.println("call");
		call.callback();
	}

	public CallBackInter getCallback() {
		return callback;
	}

	public void setCallback(CallBackInter callback) {
		this.callback = callback;
	}
}
