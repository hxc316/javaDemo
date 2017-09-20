package designed.recycle.c16.recyclea;

import java.util.Enumeration;
import java.util.Vector;

public class RecycleA {
	public static void main(String[] args) {
		Vector bin = new Vector();
		// Fill up the Trash bin:
		for (int i = 0; i < 30; i++)
			switch ((int) (Math.random() * 3)) {
			case 0:
				bin.addElement(new Aluminum(Math.random() * 100));
				break;
			case 1:
				bin.addElement(new Paper(Math.random() * 100));
				break;
			case 2:
				bin.addElement(new Glass(Math.random() * 100));
			}
		Vector glassBin = new Vector(), paperBin = new Vector(), alBin = new Vector();
		Enumeration sorter = bin.elements();
		// Sort the Trash:
		while (sorter.hasMoreElements()) {
			Object t = sorter.nextElement();
			// RTTI to show class membership:
			if (t instanceof Aluminum)
				alBin.addElement(t);
			if (t instanceof Paper)
				paperBin.addElement(t);
			if (t instanceof Glass)
				glassBin.addElement(t);
		}
		Trash.sumValue(alBin);
		Trash.sumValue(paperBin);
		Trash.sumValue(glassBin);
		Trash.sumValue(bin);
	}
} // /:~