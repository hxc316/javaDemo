package designed.bridgeModel.coffe.impl;

import designed.bridgeModel.coffe.Coffee;
import designed.bridgeModel.coffe.CoffeeImp;
public class MediumCoffee extends Coffee {

	public MediumCoffee() {
		setCoffeeImp();
	}

	@Override
	public void pourCoffee() {
		System.out.println("加了美味的牛奶");
		 CoffeeImp coffeeImp = getCoffeeImp();
		 coffeeImp.pourCoffeeImp();
		
	}
	
	
	
}
