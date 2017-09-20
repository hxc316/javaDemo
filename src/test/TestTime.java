package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
	public static void main(String[] args) throws ParseException {
		String s = "2010-06-01";
		SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date date = simFormat.parse(s);
		System.out.println("date :"+date);
		boolean_ b_ob = new boolean_();
		System.out.println(b_ob.getC());
		System.out.println(b_ob.isB());
	}
}
class boolean_{
	private boolean b;
	private Boolean c;

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public Boolean getC() {
		return c;
	}

	public void setC(Boolean c) {
		this.c = c;
	}
	
	
}
