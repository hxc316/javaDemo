package test.datagather.writeDataModel;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataWriteFile extends Thread{
	
	private Lock lock = new ReentrantLock();

	protected HashMap<String,BufferedWriter> writers = new HashMap<String, BufferedWriter>();
	
	public void init(){
		lock.lock();
		if(writers.size()!=0)return;
		writers.put("1",getBufferedWriter("1"));
		writers.put("2",getBufferedWriter("2"));
		writers.put("3",getBufferedWriter("3"));
		lock.unlock();
	}
	
	@Override
	public void run(){
		init();
		while(true){
			HashMap<String,String> data = (HashMap<String, String>) WriteData.getInstance().get();
			Set<String> keys = data.keySet();
			String key = keys.iterator().next();
			try {
				writers.get(key).write(data.get(key));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public BufferedWriter getBufferedWriter(String key){
		try {
			return new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/tt/name"+key+".txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
