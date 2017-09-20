package designed.builder;

import designed.builder.inte.ArmyBuilder;

/**
 * 模拟建造两只部队
 */
public class WarField {
 
    public static void main(String[] args) {
        Director director = new Director();
        ArmyBuilder builderA = new SceneABuilder();
        ArmyBuilder builderB = new SceneBBuilder();
        
        director.construct(builderA);
        director.construct(builderB);
        
        System.out.println(builderA.getResult());
        System.out.println(builderB.getResult());
        
        
    }
}