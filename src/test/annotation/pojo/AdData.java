package test.annotation.pojo;

import test.annotation.inter.Label;



public class AdData {

	private String adName;

	@Label(colIndex = 1)
	public String getAdName() {
		return adName;
	}
	
	public void setAdName(String adName) {
		this.adName = adName;
	}
	
	
}
