package designed.timerTask.demo2;

import designed.timerTask.demo2.myTask.myTestTask;

public class MorningTask {
	
	private final Scheduler scheduler = new Scheduler();
	TaskManage taskManager = new TaskManage();
	
	public void start(){
		scheduler.exeSchedulerTask(new SchedulerTask(){
			@Override
			public void run() {
				taskManager.run();
			}
		},new TimeDaley());
	}
	
	public MorningTask(){
		taskManager.add(new myTestTask());
	}

}
