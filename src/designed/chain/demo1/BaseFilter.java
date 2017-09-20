package designed.chain.demo1;

public abstract class BaseFilter implements MyFilter{

	private MyFilter nextFilter;
	
	public void doNextFilter(){
		if(nextFilter != null){
			nextFilter.exeFilter();
		}else{
			System.out.println("this is last filter!");
		}
	}
	
	public void setNextFilter(MyFilter filter){
		this.nextFilter = filter;
	}
}
