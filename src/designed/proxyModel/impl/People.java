package designed.proxyModel.impl;

import designed.proxyModel.Buy_car_package;

public class People implements Buy_car_package {
	private int cash;
	private String username;
	@Override
	public void buy_car() {
		System.out.println(this.username+ "�������³���");
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
