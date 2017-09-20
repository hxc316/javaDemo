package designed.decorator;

import designed.decorator.finery.BigTrouser;
import designed.decorator.finery.Tshirt;

/**
 * װ��ģʽ
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
		System.out.println("װ����:"+name);
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
