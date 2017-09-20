package test.datacache.demo1.mapData;

import java.util.HashMap;
import java.util.Set;

import com.shunwang.framework.exception.WinterException;

import test.datacache.demo1.data.DataConfig;
import test.datacache.demo1.data.DataStat;
import test.datacache.demo1.data.StatConfigCache;

public class MapDataHandler {
	public static String SITE_KEY = "sid";
	
	public void handlerData(HashMap<String,Object> data){
		
		Object siteId = data.get(SITE_KEY);
		if(siteId==null){
			throw new WinterException("无效的数据,找不到site_key!");
		}
		StatConfigCache statCache = StatConfigCache.getInstance();
		
		HashMap<String, DataConfig> statConfig = statCache.getCacheBySiteId(siteId.toString());
		DataConfig config = statConfig.values().iterator().next();
		
		String[] groupValues = new String[config.getGroupIds().length];
		for(int j=0;j<config.getGroupIds().length;j++){
			if(data.get(config.getGroupIds()[j])==null){
				throw new WinterException("无效数据,数据不全");
			}
			groupValues[j] = data.get(config.getGroupIds()[j]).toString();
		}
		Set<String> keySet = statConfig.keySet();
		
//		String[] groupValues = new String[statConfig.getGroupIds().length];
//		for(int i=0;i<statConfig.getGroupIds().length;i++){
//			String configId = statConfig.getGroupIds()[i];
//			if(data.get(configId)==null){
//				isDataOk = false;
//			}else{
//				groupValues[i] = data.get(statConfig.getGroupIds()[i]).toString();
//			}
//		}
//		if(isDataOk){
//			statConfig.setGroupValues(groupValues);
//		}
//		statConfig.add();
	}

}
