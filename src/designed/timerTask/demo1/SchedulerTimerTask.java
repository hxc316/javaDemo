package designed.timerTask.demo1;

import java.util.TimerTask;

public class SchedulerTimerTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("task execute");
	}

}
