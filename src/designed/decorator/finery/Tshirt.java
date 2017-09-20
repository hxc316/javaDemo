package designed.decorator.finery;

import designed.decorator.People;

public class Tshirt extends People{

	protected People component;
	
	public void decorate(People component){
		this.component = component;
	}
	@Override
	public void show() {
		System.out.println("¥ÛT–Ù");
		component.show();
	}
	
	
	
}
