package test.lifecycle.demo2.DataHand;

import test.lifecycle.demo2.DataHand.eventListener.NewDataFileThread;
import test.lifecycle.demo2.core.LifeEvent;
import test.lifecycle.demo2.core.LifecycleListener;
import test.lifecycle.demo2.core.SupportCycle;
import test.lifecycle.demo2.core.ThreadLife;
/**
 * 
 *	负责处理map里数据的线程
 */
public class MapHandlerImpl implements Runnable,LifecycleListener,ThreadLife{
	

	private SupportCycle servletCycle;
	
	public MapHandlerImpl(){
		this.init_();
	}
	
	@Override
	public void run() {
		
	}

	@Override
	public void lifecycleEvent(LifeEvent event) {
		if(event.getType().equals(this.START)){
			this.start();
		}
		if(event.getType().equals(this.STOP)){
			this.stop();
		}
	}

	@Override
	public void start() {
		System.out.println("map data处理线程启动...");
		servletCycle.fireLifecycleEvent(this.START);
	}

	@Override
	public void stop() {
		System.out.println("停止map data处理线程...");
		servletCycle.fireLifecycleEvent(this.STOP);
	}
	
	public void init_(){
		servletCycle = new SupportCycle(this);
		servletCycle.addLifecycleListener(new NewDataFileThread());
	}

}
