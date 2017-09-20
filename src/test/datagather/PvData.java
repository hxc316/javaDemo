package test.datagather;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PvData {
	
	public void reportData(){
		HttpURLConnection huc = null;
		try {
			URL url = new URL("http://sw.net/receiver/a");
			huc = (HttpURLConnection) url.openConnection();
			huc.setDoOutput(true);
//			huc.setRequestMethod("POST");
			huc.setRequestProperty("User-Agent", "Mozilla/4.7 [en] (Win98; I)");
			huc.setRequestProperty("Referer", "aaa");
			huc.connect();
			huc.getInputStream();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final PvData pvData = new PvData();
//		pvData.reportData();
//		ExecutorService executor = Executors.newFixedThreadPool(200);
		ExecutorService executor = Executors.newFixedThreadPool(10);
//		executor.execute(new Runnable() {
//				public void run() {
//					while(true){
//						pvData.reportData();
//						try {
//							Thread.sleep(10);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			});
		for(int i=0;i<6;i++){
			executor.execute(new Runnable() {
				public void run() {
					while(true){
						pvData.reportData();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
		}
	}

}
