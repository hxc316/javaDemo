package designed.builder;

import designed.builder.inte.ArmyBuilder;

/**
 * ��Ӧ����A��װ����
 */
public class SceneABuilder implements ArmyBuilder {
 
    ZergProduct product = new ZergProduct();
 
    public void buildHydralisk() {
        product.setHydralisk(1);
    }
 
    public void buildLurker() {
        product.setLurker(1);
    }
 
    public void buildOberload() {
        product.setOverload(1);
    }
 
    public void buildZergling() {
        product.setZergling(2);
    }
 
    public ZergProduct getResult() {
        ZergProduct finlishProduct = product;
        product = new ZergProduct();
        return finlishProduct;
    }
}
 
