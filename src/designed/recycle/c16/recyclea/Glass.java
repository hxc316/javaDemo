package designed.recycle.c16.recyclea;


/**
 * 垃圾分类
 */
class Glass extends Trash {
	static double val = 0.23f;

	Glass(double wt) {
		super(wt);
	}

	double value() {
		return val;
	}

	static void value(double newval) {
		val = newval;
	}
}
