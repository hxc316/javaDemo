package FactoryMethodModel.impl;

public class car_3w_imple extends base_car_imple{
	public void start() {
        System.out.println(this.getName() + " 车以专利技术起动了　最高速度为："
                + this.getSpeed());
    }
    public void stop() {
        System.out.println(this.getName() + " 车以专利技术停车了");
    }

}
