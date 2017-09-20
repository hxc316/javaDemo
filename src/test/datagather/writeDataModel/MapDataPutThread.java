package test.datagather.writeDataModel;

import java.util.HashMap;
import java.util.Map;

public class MapDataPutThread extends Thread {

	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		for(int i=0;i<100;i++){
			Map<String,String> mapData1 = new HashMap<String,String>();
			mapData1.put("1", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WriteData.getInstance().put(mapData1);
			Map<String,String> mapData2 = new HashMap<String,String>();
			mapData2.put("2", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			WriteData.getInstance().put(mapData2);
			Map<String,String> mapData3 = new HashMap<String,String>();
			mapData3.put("3", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
			WriteData.getInstance().put(mapData3);
		}
		System.out.println(System.currentTimeMillis() - begin);
	}

}
