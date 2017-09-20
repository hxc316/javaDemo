package adOperate.demo1;

import com.shunwang.framework.pojo.BaseObject;

public class AdAbstract extends BaseObject{
	
	private static final long serialVersionUID = 1L;
	
	private Integer state;	//广告状态

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
