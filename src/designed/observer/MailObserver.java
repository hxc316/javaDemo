package designed.observer;

import java.util.Observable;
import java.util.Observer;

//ʵ��observer �۲���
public class MailObserver implements Observer{

	/**
	 * �����ȡ��ΪMailObserver������˼�壬����һ�����������ʼ��Ĺ۲���
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("�����ʼ��Ĺ۲����Ѿ���ִ��");
		if(o instanceof BaseOb){
			BaseOb instance = (BaseOb)o;
			System.out.println("����---"+arg.toString());
			instance.to_String();
		}
	}
}
