package designed.builder.inte;

import designed.builder.ZergProduct;

public interface ArmyBuilder {
	public void buildHydralisk();
	public void buildLurker();
	public void buildOberload();
	public void buildZergling();
	public ZergProduct getResult();
}
