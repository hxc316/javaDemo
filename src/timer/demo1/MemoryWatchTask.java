package timer.demo1;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * TimerTask�࣬����Ҫ��ʱִ�е�����д��run()������
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
		//�������Ϊtrue,�򴴽��ػ��߳�new Timer(true);
		Timer timer = new Timer();
		
		//��ʱ0�����������ÿ��1����ִ��һ��
		timer.scheduleAtFixedRate(new MemoryWatchTask(), 0, 1000);
		
		//��ָ����ʱ�俪ʼִ�е�һ�Σ�ÿ�μ��1����
		//timer.scheduleAtFixedRate(new MemoryWatchTask(), new Date(), 1000);
		
		//��ָ����ʱ�����һ���Ե���
		//timer.schedule(new MemoryWatchTask(), new Date());
		
		//�ڵ�ǰʱ����ʱ3���ӽ���һ���Ե���
		//timer.schedule(new MemoryWatchTask(), 3000);
//		timer.schedule(task, time)
		
	}
}