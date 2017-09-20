package designed.timerTask.demo2.myTask;

import designed.timerTask.demo2.SchedulerTask;

public class myTestTask extends SchedulerTask{

	@Override
	public void run() {
		System.out.println("my test task run");
	}

}
