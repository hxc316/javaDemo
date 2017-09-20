package timer.demo1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * TimerTask类，将需要定时执行的任务写在run()方法中
 * */
public class MemoryWatchTask extends TimerTask {
	@Override
	public void run() {
		Runtime run = Runtime.getRuntime();
		long free = run.freeMemory();
		long total = run.totalMemory();
		System.out.println(new Date()+"\t"+free+"\t"+total);
	}
	public static void main(String[] args) {
		//如果参数为true,则创建守护线程new Timer(true);
		Timer timer = new Timer();
		
		//延时0毫秒后启动，每隔1秒钟执行一次
		timer.scheduleAtFixedRate(new MemoryWatchTask(), 0, 1000);
		
		//在指定的时间开始执行第一次，每次间隔1秒钟
		//timer.scheduleAtFixedRate(new MemoryWatchTask(), new Date(), 1000);
		
		//在指定的时间进行一次性调度
		//timer.schedule(new MemoryWatchTask(), new Date());
		
		//在当前时间延时3秒钟进行一次性调度
		//timer.schedule(new MemoryWatchTask(), 3000);
//		timer.schedule(task, time)
		
	}
}