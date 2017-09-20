package designed.recycle.c16.recyclea;

class Paper extends Trash {
	static double val = 0.10f;

	Paper(double wt) {
		super(wt);
	}

	double value() {
		return val;
	}

	static void value(double newval) {
		val = newval;
	}
}