package designed.decorator.demo1.decorator;

import designed.decorator.demo1.ClothShowInte;

public class Decorator implements ClothShowInte{

	protected ClothShowInte component;
	
	public Decorator(ClothShowInte component){
		this.component = component;
	}
	
	@Override
	public void show() {
		if(component != null){
			component.show();
		}
	}

}
