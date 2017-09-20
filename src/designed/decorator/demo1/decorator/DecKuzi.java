package designed.decorator.demo1.decorator;

import designed.decorator.demo1.ClothShowInte;

public class DecKuzi extends Decorator{

	
	public DecKuzi(ClothShowInte component) {
		super(component);
	}

	@Override
	public void show() {
		System.out.println("Пузг");
		super.show();
	}
	
}
