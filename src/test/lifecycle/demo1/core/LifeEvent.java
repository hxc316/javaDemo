package test.lifecycle.demo1.core;

import test.lifecycle.demo1.LifeCycel;

public class LifeEvent {
	
	public String type;
	private LifeCycel lifeCycel = null;
	
	
	public LifeEvent(LifeCycel lifeCycel,String type){
		this.lifeCycel = lifeCycel;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	
}
