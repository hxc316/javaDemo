package FactoryMethodModel.impl;

public class car_3w_imple extends base_car_imple{
	public void start() {
        System.out.println(this.getName() + " ����ר���������ˡ�����ٶ�Ϊ��"
                + this.getSpeed());
    }
    public void stop() {
        System.out.println(this.getName() + " ����ר������ͣ����");
    }

}
