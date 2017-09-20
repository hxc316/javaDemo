package designed.adpub.user;

public class AdminUser implements User {
	
	private String userID;
	private String username;
	private String roleId;
	private String control;
	@Override
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
}
