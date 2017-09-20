package thread.demo2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MulThread {
	
	public static void main(String[] args) throws InterruptedException {
		 new MyThread("a").start();
		 Thread.sleep(50);
		 new MyThread("b").start();
		 Thread.sleep(50);
		 new MyThread("c").start();
		 Thread.sleep(50);
		 new MyThread("d").start();
	}

}

class MyThread extends Thread{
	String sign = null;
	
	public MyThread(String sign){
		this.sign = sign;
	}
	@Override
	public void run() {
		try {
			URL url = new URL("http://sw.net/studyDemo/threadServlet.do?name="+sign);
			
			HttpURLConnection conection = (HttpURLConnection) url.openConnection();
			conection.setDoInput(true);	// 要读入数据
			conection.connect();
			InputStream input = conection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			System.out.println("name : "+reader.readLine());;
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}