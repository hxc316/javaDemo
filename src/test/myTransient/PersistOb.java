package test.myTransient;

import java.io.Serializable;

public class PersistOb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public transient String  name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
