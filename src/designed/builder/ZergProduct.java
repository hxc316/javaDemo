package designed.builder;

/**
 * Builder�Ĳ�Ʒ������һ��ɧ�Ų���
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
        return "��ǰ���Ӱ�����" + overload + "��Overload; " + zergling + "��Zergling; " + hydralisk + "��Hydralisk; " + lurker + "��Lurker";
    }
}