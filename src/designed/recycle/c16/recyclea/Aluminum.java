package designed.recycle.c16.recyclea;

class Aluminum extends Trash {
	static double val = 1.67f;

	Aluminum(double wt) {
		super(wt);
	}

	double value() {
		return val;
	}

	static void value(double newval) {
		val = newval;
	}
}