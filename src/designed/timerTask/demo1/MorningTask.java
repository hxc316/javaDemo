package designed.timerTask.demo1;

import java.util.Date;
import java.util.Timer;

public class MorningTask {
	
	private final Timer timer = new Timer();
	
	public void executeTask(){
		timer.schedule(new SchedulerTimerTask(), new Date());
	}
	

}
