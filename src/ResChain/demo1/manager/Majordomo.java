package ResChain.demo1.manager;

import designed.ResChain.demo1.Manager;
import designed.ResChain.demo1.Request;

public class Majordomo extends Manager {

	public Majordomo(String name) {
		super(name);
	}

	@Override
	public void RequestApplications(Request request) {
		if(request.getRequestType().equals("请假")&&request.getNumber()<5){
			System.out.println("总监批准：" + request.getRequestContent()+ request.getNumber()+"天");
		}else{
			if(getSuperior()!=null){
				superior.RequestApplications(request);
			}
		}
	}

}
