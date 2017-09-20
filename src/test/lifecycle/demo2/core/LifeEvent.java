package test.lifecycle.demo2.core;


public class LifeEvent {
	
	public String type;
	private ThreadLife lifeCycel = null;
	
	
	public LifeEvent(ThreadLife lifeCycel,String type){
		this.lifeCycel = lifeCycel;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	
}
