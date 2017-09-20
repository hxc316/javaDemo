package test.gamebar.privillege.demo1;

import java.util.HashMap;
import java.util.Set;

import test.gamebar.privillege.demo1.subGetSql.CityGetSql;
import test.gamebar.privillege.demo1.subGetSql.WindowGetSql;

public class GetSqlStra {

	
	public String key;
	
	public String value;
	
	public HashMap<String, GetSql> keys = new HashMap<String, GetSql>();
	
	public GetSqlStra(){
		keys.put("1", new CityGetSql(value));
		keys.put("2", new WindowGetSql(null));
	}
	
	/**
	 * 1,要删掉重复的东西
	 * @return
	 */
	public String getSql(){
		Set<String> sets = keys.keySet();
		StringBuffer sb = new StringBuffer();
		for(String set:sets){
//			sb.append(keys.get(set).getSql(value));
		}
		
		return "";
	}
	
}
