package ResChain.demo1.manager;

import designed.ResChain.demo1.Manager;
import designed.ResChain.demo1.Request;

public class GeneralManager extends Manager {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void RequestApplications(Request request) {
		if(request.getRequestType().equals("请假")){
			System.out.println("总经理批准：" + request.getRequestContent()+ request.getNumber()+"天");
		}
		else if(request.getRequestType().equals("加薪")&&request.getNumber()<=500){
			System.out.println("总经理批准：" + request.getRequestContent()+ request.getNumber()+"元");
		}else{
			System.out.println(request.getNumber()+"太多了，再说吧");
		}
	}


}
