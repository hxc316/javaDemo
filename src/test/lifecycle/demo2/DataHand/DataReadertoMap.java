package test.lifecycle.demo2.DataHand;

import test.lifecycle.demo2.DataHand.eventListener.FileMonitor;
import test.lifecycle.demo2.core.LifeEvent;
import test.lifecycle.demo2.core.LifecycleListener;
import test.lifecycle.demo2.core.SupportCycle;
import test.lifecycle.demo2.core.ThreadLife;

/**
 * 从队列里取数据 处理
 *
 */
public class DataReadertoMap implements Runnable,ThreadLife,LifecycleListener{

	private SupportCycle servletCycle;
	public DataReadertoMap(){
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
		System.out.println("准备启动数据解析线程...");
		servletCycle.fireLifecycleEvent(this.START);
	}

	@Override
	public void stop() {
		System.out.println("停止数据解析线程...");
		servletCycle.fireLifecycleEvent(this.STOP);
	}
	
	private void init_(){
		servletCycle = new SupportCycle(this);
		servletCycle.addLifecycleListener(new FileMonitor());
		servletCycle.addLifecycleListener(new MapHandlerImpl());
	}
}
