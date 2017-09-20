package test.gamebar.privillege.demo1.subGetSql;

import test.gamebar.privillege.demo1.GetSql;

public class CityGetSql extends GetSql{

	public CityGetSql(String value) {
		super(value);
	}

	@Override
	public String getSql() {
		return "cityId in " + super.value;
	}

}
