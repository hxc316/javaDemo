package designed.timerTask.demo2;

import java.util.ArrayList;
import java.util.List;

public class TaskManage extends SchedulerTask{

	List<SchedulerTask> tasks = new ArrayList<SchedulerTask>();
	@Override
	public void run() {
		for(SchedulerTask task:tasks){
			task.run();
		}
	}
	
	public void add(SchedulerTask task){
		tasks.add(task);
	}
}
