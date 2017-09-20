package designed.bridgeModel.coffe.impl;

import designed.bridgeModel.coffe.Coffee;
import designed.bridgeModel.coffe.CoffeeImp;

public class SuperSizeCoffee extends Coffee {
	public SuperSizeCoffee() {
		setCoffeeImp();
	}

	public void pourCoffee() {
		CoffeeImp coffeeImp = this.getCoffeeImp();
		// 我们以重复次数来说明是冲中杯还是大杯 ,重复5次是大杯
		for (int i = 0; i < 2; i++) {
			coffeeImp.pourCoffeeImp();
		}
	}
}
