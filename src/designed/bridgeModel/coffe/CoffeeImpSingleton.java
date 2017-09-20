package designed.bridgeModel.coffe;

import designed.bridgeModel.coffe.impl.FragrantCoffeeImp;
import designed.bridgeModel.coffe.impl.MediumCoffee;
import designed.bridgeModel.coffe.impl.SuperSizeCoffee;

public class CoffeeImpSingleton {
	private static CoffeeImp coffeeImp;
	
	public CoffeeImpSingleton(CoffeeImp coffeeImpIn){
		this.coffeeImp = coffeeImpIn;
	}
	
	public static CoffeeImp getTheCoffeeImp(){
		return coffeeImp;
	}
	
	public static void main(String[] args) {
		
		CoffeeImpSingleton singleton = new CoffeeImpSingleton(new FragrantCoffeeImp());
		MediumCoffee mediumCoffee = new MediumCoffee();
		mediumCoffee.pourCoffee();
		System.out.println("---------------------------------------");
		SuperSizeCoffee superCoffee = new SuperSizeCoffee();
		superCoffee.pourCoffee();
		
		
	}
	
}
