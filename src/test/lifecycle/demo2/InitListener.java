package test.lifecycle.demo2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import test.lifecycle.demo2.DataHand.DataReadertoMap;
import test.lifecycle.demo2.DataHand.eventListener.FileMonitor;
import test.lifecycle.demo2.core.SupportCycle;
import test.lifecycle.demo2.core.ThreadLife;

public class InitListener extends HttpServlet implements ServletContextListener,ThreadLife{
	
	private SupportCycle servletCycle;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		this.stop();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		this.start();
	}
	
	public static void main(String[] args) {
		InitListener listener = new InitListener();
		listener.init_();
//		listener.start();
		listener.stop();
	}
	
	private void init_(){
		servletCycle = new SupportCycle(this);
		servletCycle.addLifecycleListener(new DataReadertoMap());
	}

	@Override
	public void start() {
		System.out.println("tomcat 启动了...");
		servletCycle.fireLifecycleEvent(this.START);
	}

	@Override
	public void stop() {
		System.out.println("tomcat 停止了...");
		servletCycle.fireLifecycleEvent(this.STOP);
	}
	
	

}
