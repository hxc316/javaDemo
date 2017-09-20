package designed.recycle.c16.recyclea;

import java.util.Enumeration;
import java.util.Vector;

abstract class Trash {
	private double weight;

	Trash(double wt) {
		weight = wt;
	}

	abstract double value();

	double weight() {
		return weight;
	}

	// Sums the value of Trash in a bin:
	static void sumValue(Vector bin) {
		Enumeration e = bin.elements();
		double val = 0.0f;
		while (e.hasMoreElements()) {
			// One kind of RTTI:
			// A dynamically-checked cast
			Trash t = (Trash) e.nextElement();
			// Polymorphism in action:
			val += t.weight() * t.value();
			System.out.println("weight of " +
			// Using RTTI to get type
					// information about the class:
					t.getClass().getName() + " = " + t.weight());
		}
		System.out.println("Total value = " + val);
	}
}
