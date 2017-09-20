package designed.timerTask.demo2;

import java.util.TimerTask;

public abstract class SchedulerTask implements Runnable {
	
	public abstract void run();
	
	public TimerTask myTask;
	
	

}
