package thread.demo6;

public class DoUpdThread extends Thread {

	private DoCrud crud;
	
	public DoUpdThread(DoCrud crud){
		this.crud = crud;
	}
	@Override
	public void run() {
		crud.upd();
	}
	
	
}
