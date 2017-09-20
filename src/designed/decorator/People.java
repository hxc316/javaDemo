package designed.decorator;

import designed.decorator.finery.BigTrouser;
import designed.decorator.finery.Tshirt;

/**
 * 装饰模式
 * @author Administrator
 *
 */
public class People {
	
	public String name;
	
	public People(){}
	
	public People(String name){
		this.name = name;
	}
	
	public void show(){
		System.out.println("装扮者:"+name);
	}

	public static void main(String[] args) {
		People people = new People("xiaoxiao");
		BigTrouser bt = new BigTrouser();
		Tshirt shirt = new Tshirt();
		
		bt.decorate(people);
		shirt.decorate(bt);
		
		shirt.show();
	}
}
