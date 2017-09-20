package test.fanhua.dao;


import test.fanhua.pojo.BaseOb;

public class BaseDao<Pojo extends BaseOb> extends Dao {
	
	public Class pojo;
	

	void setClass(Class a){
		this.pojo = a;
	}
	
	public void del(){
		
	}

	@Override
	public void add(BaseOb pojo) {
		
	}

}
