package designed.observer;

import java.util.Observable;
import java.util.Observer;

//实现observer 观察者
public class MailObserver implements Observer{

	/**
	 * 这个类取名为MailObserver，顾名思义，她是一个用来发送邮件的观察者
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("发送邮件的观察者已经被执行");
		if(o instanceof BaseOb){
			BaseOb instance = (BaseOb)o;
			System.out.println("参数---"+arg.toString());
			instance.to_String();
		}
	}
}
