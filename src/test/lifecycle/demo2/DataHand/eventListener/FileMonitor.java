package test.lifecycle.demo2.DataHand.eventListener;

import test.lifecycle.demo2.core.LifeEvent;
import test.lifecycle.demo2.core.LifecycleListener;
import test.lifecycle.demo2.core.ThreadLife;
/**
 * 功能：
 *	文件扫描程序
 */
public class FileMonitor implements LifecycleListener{

	@Override
	public void lifecycleEvent(LifeEvent event) {
		if(event.getType().equals(ThreadLife.START)){
			System.out.println("数据文件扫描线程启动....");
		}
		if(event.getType().equals(ThreadLife.STOP)){
			System.out.println("停止数据文件扫描线程...");
		}
	}

}
