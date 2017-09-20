package designed.timerTask.demo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class TaskManager {

  final	Timer timer = new Timer();
  
  List<SchedulerTimerTask> tasks = new ArrayList<SchedulerTimerTask>();
	
	public void executeTask(){
		for(SchedulerTimerTask task:tasks){
			timer.schedule(task, new Date());
		}
	}
	
	public void add(SchedulerTimerTask task){
		tasks.add(task);
	}
	
}
