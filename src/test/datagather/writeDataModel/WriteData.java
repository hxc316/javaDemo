package test.datagather.writeDataModel;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WriteData {
	private static Lock lock = new ReentrantLock();
	private static WriteData writeData = null;
	protected static BlockingDeque<Map<String,String>> data = new LinkedBlockingDeque<Map<String,String>>(1000) ;
	
	protected static WriteData getInstance(){
		lock.lock();
		if(writeData == null){
			writeData = new WriteData();
		}
		lock.unlock();
		return writeData;
	}
	
	private WriteData(){};
	
	protected static BlockingDeque<Map<String,String>> getDeque(){
		return data;
	}
	
	
	public void put(Map<String,String> mapData){
		try {
			data.put(mapData);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Map<String,String> get(){
		try {
			return data.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
