package designed.builder;

/**
 * Builder的产品，代表一组骚扰部队
 */
public class ZergProduct {
 
    private int overload;
 
    private int zergling;
 
    private int hydralisk;
 
    private int lurker;
 
    public int getOverload() {
        return overload;
    }
 
    public void setOverload(int overload) {
        this.overload = overload;
    }
 
    public int getZergling() {
        return zergling;
    }
 
    public void setZergling(int zergling) {
        this.zergling = zergling;
    }
 
    public int getHydralisk() {
        return hydralisk;
    }
 
    public void setHydralisk(int hydralisk) {
        this.hydralisk = hydralisk;
    }
 
    public int getLurker() {
        return lurker;
    }
 
    public void setLurker(int lurker) {
        this.lurker = lurker;
    }
 
    public String toString() {
        return "当前部队包括：" + overload + "个Overload; " + zergling + "个Zergling; " + hydralisk + "个Hydralisk; " + lurker + "个Lurker";
    }
}