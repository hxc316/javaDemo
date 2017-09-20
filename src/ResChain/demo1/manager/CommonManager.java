package ResChain.demo1.manager;

import designed.ResChain.demo1.Manager;
import designed.ResChain.demo1.Request;

public class CommonManager extends Manager {

	public CommonManager(String name) {
		super(name);
	}

	@Override
	public void RequestApplications(Request request) {
		if(request.getRequestType().equals("请假")&&request.getNumber()<2){
			System.out.println("经理批准：" + request.getRequestContent()+ request.getNumber()+"天");
		}else{
			if(getSuperior()!=null){
				getSuperior().RequestApplications(request);
			}
		}
	}

}
