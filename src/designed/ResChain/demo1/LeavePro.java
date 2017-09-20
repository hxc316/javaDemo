package designed.ResChain.demo1;

import ResChain.demo1.manager.CommonManager;
import ResChain.demo1.manager.GeneralManager;
import ResChain.demo1.manager.Majordomo;

public class LeavePro {
	

	public static void main(String[] args) {
		
		CommonManager jinli = new CommonManager("经理");		//经理
	    Majordomo zongjian = new Majordomo("总监");			//总监
	    GeneralManager zhongjingli = new GeneralManager("总经理");	//总经理
	    
	    jinli.SetSuperior(zongjian);
	    zongjian.SetSuperior(zhongjingli);
	    
	    Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("小菜请假");
        request.setNumber(1);
        jinli.RequestApplications(request);	//经理处理

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小菜请假");
        request2.setNumber(4);
        jinli.RequestApplications(request2);	//总监处理
        
        Request request5 = new Request();
        request5.setRequestType("请假");
        request5.setRequestContent("小菜请假");
        request5.setNumber(10);
        jinli.RequestApplications(request5);	//总监处理

        Request request3 = new Request();
        request3.setRequestType("加薪");
        request3.setRequestContent("小菜请求加薪");
        request3.setNumber(500);
        jinli.RequestApplications(request3);

        Request request4 = new Request();
        request4.setRequestType("加薪");
        request4.setRequestContent("小菜请求加薪");
        request4.setNumber(1000);
        jinli.RequestApplications(request4);

	}


}
