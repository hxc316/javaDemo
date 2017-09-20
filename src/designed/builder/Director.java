package designed.builder;

import designed.builder.inte.ArmyBuilder;

/**
 * ���������ߵĽ������
 */
public class Director {
 
    public void construct(ArmyBuilder builder) {
        builder.buildOberload();
        builder.buildHydralisk();
        builder.buildZergling();
        builder.buildLurker();
    }
}
