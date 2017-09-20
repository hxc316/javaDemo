package designed.observer;

import java.util.Observable;
import java.util.Observer;
//Ҫ�̳� Observable
public class Subject extends Observable implements BaseOb{
	
	/**
	 * ҵ�񷽷���һ��ִ��ĳ����������֪ͨ�۲���
	 */
	public void doBusiness(){
		if (true) {
			super.setChanged();
		}
		super.notifyObservers("���ڻ�û�еĲ���");
	}

	
	public static void main(String [] args) {
		//����һ�����۲���
		Subject subject = new Subject();
		
		//���������۲���
		Observer mailObserver = new MailObserver();
		Observer jmsObserver = new JMSObserver();
		
		//�������۲��߼ӵ����۲����б���
		subject.addObserver(mailObserver);
		subject.addObserver(jmsObserver);
		
		//ִ��ҵ�����
		subject.doBusiness();
	}


	@Override
	public void to_String() {
		System.out.println("to String");
	}
}
