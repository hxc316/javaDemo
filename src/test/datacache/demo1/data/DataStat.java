package test.datacache.demo1.data;

import com.shunwang.framework.exception.WinterException;

public class DataStat extends DataConfig{
	private Integer sumCnt;
	private String[] groupValues;
	
	public String getKey(){
		if(super.groupIds == null){
			throw new WinterException("数据未初始化!");
		}
		StringBuffer key = new StringBuffer();
		for(int i=0;i<super.groupIds.length;i++){
			key.append("_");
			key.append(groupValues[i]);
		}
		return key.substring(1);
	}
	
	public Integer getSumCnt() {
		return sumCnt;
	}
	public void setSumCnt(Integer sumCnt) {
		this.sumCnt = sumCnt;
	}
	public String[] getGroupValues() {
		return groupValues;
	}
	public void setGroupValues(String[] groupValues) {
		this.groupValues = groupValues;
	}
	
	
}
