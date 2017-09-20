package test.lifecycle.demo1;

import test.lifecycle.demo1.core.OffWork;
import test.lifecycle.demo1.core.StandardListener;
import test.lifecycle.demo1.core.SupportCycle;
/**
 * 有生命周期的都需要实现 lifeCycel接口
 */
public class StandardContext implements LifeCycel{
	
	private SupportCycle myCycle;
	
	public static void main(String[] args) {
		StandardContext context = new StandardContext();
		context.start();
		context.stop();
		
	}
	@Override
	public void start() {
		init();
		//............
		myCycle.fireLifecycleEvent(LifeCycel.START);
//		
	}
	
	@Override
	public void stop() {
		myCycle.fireLifecycleEvent(LifeCycel.STOP);
	}

	private void init() {
		myCycle = new SupportCycle(this);
		myCycle.addLifecycleListener(new StandardListener());
		myCycle.addLifecycleListener(new OffWork());
	}

}
