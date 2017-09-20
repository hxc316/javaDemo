package test.lifecycle.demo2.core;



public final class SupportCycle {
	
//	private List<MyLifecycleListener> cycleLis;
	/**
	 * 1，用数组的好处？
	 */
	private LifecycleListener[] myListeners = new LifecycleListener[0];
	private final Object listenersLock = new Object();
	
	private ThreadLife threadLife;
	
	public SupportCycle( ThreadLife threadLife){
		this.threadLife = threadLife;
	}
	/**
	 * 通知所有敢兴趣的监听器
	 * @param type
	 */
	public void fireLifecycleEvent(String type){
		LifeEvent event = new LifeEvent(threadLife,type);
		LifecycleListener[] fireListener = myListeners;
		for(LifecycleListener listener:fireListener){
			listener.lifecycleEvent(event);
		}
	}

	public void addLifecycleListener(LifecycleListener listener) {
		synchronized (listenersLock) {
			LifecycleListener[] listeners = new LifecycleListener[myListeners.length+1];
			for(int i=0;i<myListeners.length;i++){
				listeners[i] = myListeners[i];
			}
			listeners[myListeners.length] = listener;
			myListeners = listeners;
		}
	}
	
	
	
}
