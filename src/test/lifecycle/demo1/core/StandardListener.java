package test.lifecycle.demo1.core;

import test.lifecycle.demo1.LifeCycel;
import test.lifecycle.demo1.MyLifecycleListener;

public class StandardListener implements MyLifecycleListener{

	@Override
	public void lifecycleEvent(LifeEvent event) {
		if(LifeCycel.START.equals(event.getType())){
			System.out.println("开始上班：胡太斯来了");
		}else if(LifeCycel.STOP.equals(event.getType())){
			System.out.println("下班：胡太斯回家");
		}
		
	}

}
