package thread.demo6;

public class DoThread extends Thread{
	
	private DoCrud crud;
	public DoThread(DoCrud crud){
		this.crud = crud;
	}
	@Override
	public void run() {
		crud.sch();
	}
	

}
