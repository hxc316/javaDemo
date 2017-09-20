package designed.ResChain.demo1;

/**
 * 管理者
 * 
 * @author huxc
 * 
 */
public abstract class Manager {

	protected String name;

	// 管理者的上级
	protected Manager superior;

	public Manager(String name) {
		this.name = name;
	}

	// 设置管理者的上级
	public void SetSuperior(Manager superior) {
		this.superior = superior;
	}

	public Manager getSuperior() {
		return superior;
	}

	public void setSuperior(Manager superior) {
		this.superior = superior;
	}

	// 申请请求
	abstract public void RequestApplications(Request request);

}
