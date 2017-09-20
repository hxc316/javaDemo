package designed.proxyModel.impl;

import designed.proxyModel.Buy_car_package;

public class Proxy_buy_car_imple implements Buy_car_package {

	private People people; 
	
	@Override
	public void buy_car() {
		  if (people.getCash() > 3000) {
	            System.out.println(people.getUsername() + "��" + people.getCash()
	                    + "�顡�����³������׽���");
	        } else {
	            System.out.println(people.getUsername() + "��Ǯ��������������!");
	        }
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
}
