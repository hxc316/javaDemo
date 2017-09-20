package designed.timerTask.demo1.tag1.impl;

import designed.timerTask.demo1.tag1.AbsTimerTask;

public class ExtendTimerTask extends AbsTimerTask{

	@Override
	public void run() {
		System.err.println("my task run");
	}

	
}
