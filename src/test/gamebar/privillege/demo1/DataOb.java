package test.gamebar.privillege.demo1;

import java.util.ArrayList;
import java.util.List;

import test.gamebar.privillege.demo1.subGetSql.WindowGetSql;

public class DataOb {
	
	private Boolean isWindow;
	
	private Boolean isDeskIcon;
	
	private Boolean isVersion;

	public Boolean getIsVersion() {
		return isVersion;
	}
	public void setIsVersion(Boolean isVersion) {
		this.isVersion = isVersion;
	}

	public List<GetSql> toSqlCondition(){
		List<GetSql> getSqls = new ArrayList<GetSql>();
		if(isWindow){
			getSqls.add(new WindowGetSql(null));
		}
		return getSqls;
	}
}
