package designed.builder;

import designed.builder.inte.ArmyBuilder;

/**
 * 适应场景B的装配器
 */
public class SceneBBuilder implements ArmyBuilder {
 
    ZergProduct product = new ZergProduct();
 
    public void buildHydralisk() {
        product.setHydralisk(4);
    }
 
    public void buildLurker() {
        product.setLurker(0);
    }
 
    public void buildOberload() {
        product.setOverload(0);
    }
 
    public void buildZergling() {
        product.setZergling(0);
    }
 
    public ZergProduct getResult() {
        ZergProduct finlishProduct = product;
        product = new ZergProduct();
        return finlishProduct;
    }
}