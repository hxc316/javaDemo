package designed.builder;

import designed.builder.inte.ArmyBuilder;

/**
 * ��Ӧ����B��װ����
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