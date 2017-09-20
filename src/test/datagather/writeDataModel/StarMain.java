package test.datagather.writeDataModel;

public class StarMain {
	
	public static void main(String[] args) {
		
		MapDataPutThread mapDataPutThread = new MapDataPutThread();
		mapDataPutThread.start();
		
		DataWriteFile dataWriteFile = new DataWriteFile();
		dataWriteFile.start();
		
		MonitorThread monitorThread = new MonitorThread();
		monitorThread.start();
	}
}


class MonitorThread extends Thread{
	private boolean isStop = false;
	@Override
	public void run() {
		while(isStop){
			try {
				Thread.sleep(1000*3);
				if(WriteData.getDeque().size() == 0){
					isStop = true;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

/**
  1000000 70M 2012'    4012  6036
  1000000 * 2 140M 4109'  
  1000000* 3 210M  6266'
  
**/