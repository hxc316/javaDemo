package test.lifecycle.demo2.DataHand.eventListener;

import test.lifecycle.demo2.core.LifeEvent;
import test.lifecycle.demo2.core.LifecycleListener;
import test.lifecycle.demo2.core.ThreadLife;

public class NewDataFileThread implements LifecycleListener{

	@Override
	public void lifecycleEvent(LifeEvent event) {
		if(event.getType().equals(ThreadLife.START)){
			System.out.println("监测生成新文件线程启动....");
		}
		if(event.getType().equals(ThreadLife.STOP)){
			System.out.println("停止监测生成新文件线程...");
		}
	}

}
