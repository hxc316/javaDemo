package test.gamebar.privillege.demo1;

public abstract class GetSql {
	
	protected String value; 
	
	public GetSql(String value){
		this.value = value;
	}
	
	public abstract String getSql();

}
