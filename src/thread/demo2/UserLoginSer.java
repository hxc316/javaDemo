package thread.demo2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserLoginSer {
	public static void main(String[] args) {
		loginThread thread = new loginThread();
		thread.start();
	}
}

class loginThread extends Thread{
	String name ;
	String pw;
	String act;
	
	public loginThread(String name,String pw){
		this.name = name;
		this.pw = pw;
		this.act = act;
	}
	public loginThread(){}
	@Override
	public void run() {
		try {
//			URL url = new URL("http://sw.net/studyDemo/thread.do?name=");
			URL url = new URL("http://sw.net/receiver/a?aid=100");
			
			HttpURLConnection conection = (HttpURLConnection) url.openConnection();
			conection.setDoInput(true);	// 要读入数据
			conection.connect();
			InputStream input = conection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			System.out.println("name : "+reader.readLine());;
//			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
