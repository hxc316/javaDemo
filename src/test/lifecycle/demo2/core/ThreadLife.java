package test.lifecycle.demo2.core;

public interface ThreadLife {

	public final static String START = "start";
	
	public final static String STOP = "stop";
	
	public void start();
	
	public void stop();
	
}
