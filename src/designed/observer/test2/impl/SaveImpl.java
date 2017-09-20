package designed.observer.test2.impl;

import java.util.Observable;

import designed.observer.test2.SaveInter;

public class SaveImpl extends Observable implements SaveInter{

	@Override
	public void save() {
		System.out.println("save user");
		this.setChanged();
		this.notifyObservers();
	}

}
