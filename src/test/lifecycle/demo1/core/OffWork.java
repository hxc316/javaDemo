package test.lifecycle.demo1.core;

import test.lifecycle.demo1.LifeCycel;
import test.lifecycle.demo1.MyLifecycleListener;

public class OffWork implements MyLifecycleListener {

	@Override
	public void lifecycleEvent(LifeEvent event) {
		if(LifeCycel.START.equals(event.getType())){
			System.out.println("开始上班：胡新超来了");
		}else if(LifeCycel.STOP.equals(event.getType())){
			System.out.println("下班：胡新超准备回家");
		}
	}

}
