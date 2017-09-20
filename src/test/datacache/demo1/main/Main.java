package test.datacache.demo1.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.datacache.demo1.data.DataConfig;
import test.datacache.demo1.data.StatConfigCache;

public class Main {

	List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	DataConfig dataConfig = new DataConfig();
	public void initData(){
		Map<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("siteId","1001");
		hashMap.put("cityId",457);
		hashMap.put("aid", "11187");
		hashMap.put("", 11);
		list.add((HashMap<String, Object>) hashMap);
		list.add((HashMap<String, Object>) hashMap);
		list.add((HashMap<String, Object>) hashMap);
		list.add((HashMap<String, Object>) hashMap);
	}
	
	public void initCache(){
		DataConfig config = new DataConfig();
		config.setSiteId("1001");
		String[] groupIds = {"aid"};
		config.setGroupIds(groupIds);
		config.setTableName("adPv");
		config.setSumCloumn("pvCnt");
		
		HashMap<String,DataConfig> dataCache = new HashMap<String, DataConfig>();
		
		dataCache.put("", config);
		StatConfigCache.getInstance().updateCacheBySiteId("1001",dataCache);
		
	}
	
	public void handlerData(){
		for(HashMap<String,Object> data:list){
//			dataConfig.add(groupIds)
		}
	}
	
	public static void main(String[] args) {
		Main main= new Main();
		main.initCache();
		main.initData();
		
		
		
	}
}
