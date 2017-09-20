package test.lifecycle.demo1.core;

import java.util.List;

import test.lifecycle.demo1.LifeCycel;
import test.lifecycle.demo1.MyLifecycleListener;

public final class SupportCycle {
	
//	private List<MyLifecycleListener> cycleLis;
	/**
	 * 1，用数组的好处？
	 */
	private MyLifecycleListener[] myListeners = new MyLifecycleListener[0];
	private final Object listenersLock = new Object();
	
	private LifeCycel lifeCycel;
	
	public SupportCycle(LifeCycel lifeCycel){
		this.lifeCycel = lifeCycel;
	}
	/**
	 * 通知所有敢兴趣的监听器
	 * @param type
	 */
	public void fireLifecycleEvent(String type){
		LifeEvent event = new LifeEvent(lifeCycel,type);
		MyLifecycleListener[] fireListener = myListeners;
		for(MyLifecycleListener listener:fireListener){
			listener.lifecycleEvent(event);
		}
	}

	public void addLifecycleListener(MyLifecycleListener listener) {
		synchronized (listenersLock) {
			MyLifecycleListener[] listeners = new MyLifecycleListener[myListeners.length+1];
			for(int i=0;i<myListeners.length;i++){
				listeners[i] = myListeners[i];
			}
			listeners[myListeners.length] = listener;
			myListeners = listeners;
		}
	}
	
	
	
}
