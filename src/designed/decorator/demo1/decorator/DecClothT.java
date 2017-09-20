package designed.decorator.demo1.decorator;

import designed.decorator.demo1.ClothShowInte;

public class DecClothT extends Decorator{

	public DecClothT(ClothShowInte component) {
		super(component);
	}

	@Override
	public void show() {
		System.out.println("TÐô");
		super.show();
	}
	
}
