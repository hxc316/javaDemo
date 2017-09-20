package designed.decorator.demo1;

import designed.decorator.demo1.beDecorator.ShowXiaocai;
import designed.decorator.demo1.decorator.DecClothT;
import designed.decorator.demo1.decorator.DecKuzi;

public class Main {

	public static void main(String[] args) {
		ClothShowInte showMy = new ShowXiaocai();
		showMy.show();
		
//		DecClothT Tshirt = new DecClothT(showMy);
//		Tshirt.show();
		
		DecKuzi kuzi = new DecKuzi(showMy);
		kuzi.show();
	}

}
