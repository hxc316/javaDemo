package adOperate.demo2;

import com.shunwang.framework.pojo.BaseObject;

public class AdStateBase extends BaseObject{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 正常 0
	 */
	public static final int OP_SIGN_COMMON = 0;
	/**
	 * 暂停 1
	 */
	public static final int OP_SIGN_PAUSE = 1;
	/**
	 * 停止 2
	 */
	public static final int OP_SIGN_STOP = 2;
	
	/**
	 * 待投放 0
	 */
	public static final int TIME_STATE_TODO = 0;
	/**
	 * 投放中 1
	 */
	public static final int TIME_STATE_DOING = 1;
	/**
	 * 投放结束 2
	 */
	public static final int TIME_STATE_DONE = 2;
	/**
	 * 广告发布 带审核0
	 */
	public static final int CONFIRM_TODO = 0;
	/**
	 * 财务审核通过 1
	 */
	public static final int CONFIRM_FINANCE_YES = 1;
	/**
	 * 财务审核不通过2 
	 */
	public static final int CONFIRM_FINANCE_NO = 2;
	/**
	 * 运营审核通过3
	 */
	public static final int CONFIRM_YUNYINGZY_YES = 3;
	/**
	 * 运营审核不通过 4
	 */
	public static final int CONFIRM_YUNYING_NO = 4;
	
	private Integer timeState;
	
	private Integer opState;
	
	private Integer confirmState;

	public Integer getTimeState() {
		return timeState;
	}

	public void setTimeState(Integer timeState) {
		this.timeState = timeState;
	}

	public Integer getOpState() {
		return opState;
	}

	public void setOpState(Integer opState) {
		this.opState = opState;
	}

	public Integer getConfirmState() {
		return confirmState;
	}

	public void setConfirmState(Integer confirmState) {
		this.confirmState = confirmState;
	}
}
