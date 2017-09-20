package designed.adpub.user;

public class MarketUser implements User {
	
	private String userID;
	private String username;
	private String roleId;
	private String sellIdD;
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
	public String getSellIdD() {
		return sellIdD;
	}
	public void setSellIdD(String sellIdD) {
		this.sellIdD = sellIdD;
	}
	

}
