package test.datacache.demo1.data;

import java.util.HashMap;

public class StatConfigCache {
	
	private static StatConfigCache cache = new StatConfigCache();
	
	private StatConfigCache(){}
	
	public static synchronized StatConfigCache getInstance(){
		if(cache == null){
			cache = new StatConfigCache();
		}
		return cache;
	}
	
	
	private HashMap<String,HashMap<String,DataConfig>> statConfigCache = new HashMap<String, HashMap<String, DataConfig>>();
	
	public HashMap<String, DataConfig> getCacheBySiteId(String siteId){
		return this.statConfigCache.get(siteId);
	}
	
	public void updateCacheBySiteId(String siteId,HashMap<String,DataConfig> data){
		this.statConfigCache.put(siteId, data);
	}
	
	public void removeCacheBySiteid(String siteId){
		this.statConfigCache.remove(siteId);
	}

}
