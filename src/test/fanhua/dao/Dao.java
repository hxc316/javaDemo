package test.fanhua.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import test.fanhua.pojo.BaseOb;

public abstract class Dao<pojo extends BaseOb> {
	private Class pojo;
	public Dao(){
		//session();
		Type[] type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
		pojo = ((Class)type[0]);
	}
	
	
	public abstract void add(BaseOb pojo);
}
