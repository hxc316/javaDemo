package test.gamebar.privillege.demo1.subGetSql;

import test.gamebar.privillege.demo1.GetSql;

public class WindowGetSql extends GetSql{

	public WindowGetSql(String value) {
		super(value);
	}

	@Override
	public String getSql() {
		return "is_window_close = false";
	}

}
