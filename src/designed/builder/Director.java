package designed.builder;

import designed.builder.inte.ArmyBuilder;

/**
 * 描述建造者的建造过程
 */
public class Director {
 
    public void construct(ArmyBuilder builder) {
        builder.buildOberload();
        builder.buildHydralisk();
        builder.buildZergling();
        builder.buildLurker();
    }
}
