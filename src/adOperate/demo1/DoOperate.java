package adOperate.demo1;

import com.shunwang.framework.exception.WinterException;

public abstract class DoOperate {
	
	public static final int common = 0;	//播放
	public static final int pause = 1;	//暂停
	
	public AdAbstract ad;
	
	public DoOperate(AdAbstract ad){
		if(ad == null){
			throw new WinterException("参数错误");
		}
		this.ad = ad;
	}
	/**
	 * 
	 * @param ad
	 * @throws 没有操作权限
	 * @return
	 */
	public AdAbstract doPause(){
		if(ad.getState().intValue()!=pause){
			throw new WinterException("没有操作权限!");
		}
		ad.setState(common);
		return ad;
	}
	
	public AdAbstract doStart(){
		if(ad.getState().intValue()!=common){
			throw new WinterException("没有操作权限!");
		}
		ad.setState(pause);
		return ad;
	}
	
	/**
	 * 是否具有权限
	 * @return
	 */
	public abstract boolean isHashRight();
}
