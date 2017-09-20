package designed.timerTask.demo2;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
	
	private final Timer timer = new Timer();//写在外面可以公用，不要写在方法的里面
	
	class innertScheduler extends TimerTask{
		@Override
		public void run() {
		}
	}
	
	
	public void  exeSchedulerTask(SchedulerTask task,TimerNext timerNext){
		task.myTask = new innertScheduler();
		// 如果这个地方是date ，如何适应所有。
		timer.schedule(task.myTask, timerNext.nextDate());
	}
}
