package designed.observer.test;

import java.util.Observable;
import java.util.Observer;

public class TransactionOb implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		Object ob = arg;
		System.out.println("tranction doing ...");
	}

}
