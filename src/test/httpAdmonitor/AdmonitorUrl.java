package test.httpAdmonitor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdmonitorUrl {

	
	public static void main(String[] args) throws IOException {
		System.out.println("begin connect...");
//		URL url = new URL("http://sw.net/studyDemo/adMonitor/adMonitorGroup.html");
//		URL url = new URL("http://news.gyyx.cn/counter.ashx?position_id=314&class_id=3&page_id=2&source_id=12&game_id=1&pc=5&sc=27&mc=24&gc=2&ul=http%3a%2f%2fwd.gyyx.cn%2fRegister%2freg.html&mt=2 ");
		URL url = new URL("http://wd.gyyx.cn/Registser/reg.html");
		long beginTime = System.currentTimeMillis();
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setConnectTimeout(0);
		con.connect();
		int stateCode = con.getResponseCode();
		con.getInputStream().close();
		long endTime = System.currentTimeMillis();
		if(stateCode == 200){
			System.out.println("end conection: sucess");
		}
//		con.disconnect();
		System.out.println("message : "+stateCode);
		System.out.println("time :" + (endTime - beginTime));
	}
}
