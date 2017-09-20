package adOperate.demo2;

import com.shunwang.framework.exception.WinterException;

public class DoOperate {
	
	private AdStateBase ad;
	
	public DoOperate(AdStateBase ad){
		if(ad == null){
			throw new WinterException("广告为空!");
		}
		this.ad = ad;
	}
	/**
	 * 发布广告初始状态
	 * @return
	 */
	public AdStateBase pubAd(){
		ad.setOpState(AdStateBase.OP_SIGN_COMMON);
		ad.setConfirmState(AdStateBase.CONFIRM_TODO);
		ad.setTimeState(AdStateBase.TIME_STATE_TODO);
		return ad;
	}
	/**
	 * 财务确认是否通过
	 * @param isPass
	 * @return
	 */
	public AdStateBase financeConfirm(boolean isPass){
		if(isPass)
			ad.setConfirmState(AdStateBase.CONFIRM_FINANCE_YES);
		else
			ad.setConfirmState(AdStateBase.CONFIRM_FINANCE_NO);
		
		return ad;
	}
	/**
	 * 运营审核是否通过
	 * @param isPass
	 * @return
	 */
	public AdStateBase yunyingConfirm(boolean isPass){
		if(isPass)
			ad.setConfirmState(AdStateBase.CONFIRM_YUNYINGZY_YES);
		else
			ad.setConfirmState(AdStateBase.CONFIRM_FINANCE_NO);
		
		return ad;
	}
	/**
	 * 暂停广告
	 * @return
	 */
	public AdStateBase pauseAd(){
		//状态控制
		ad.setOpState(AdStateBase.OP_SIGN_PAUSE);
		return ad;
	}
	/**
	 * 播放广告
	 * @return
	 */
	public AdStateBase startAd(){
		ad.setOpState(AdStateBase.OP_SIGN_COMMON);
		return ad;
	}
	/**
	 * 停止广告
	 * @return
	 */
	public AdStateBase stopAd(){
		ad.setOpState(AdStateBase.OP_SIGN_STOP);
		return ad;
	}
}
