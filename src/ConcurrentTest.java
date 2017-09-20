import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

public class ConcurrentTest {

	private static int thread_num = 100;

	private static int client_num = 100;

//	private static Map keywordMap = new HashMap();
	
	private final static BlockingDeque pop = new LinkedBlockingDeque(1000);


	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		for(int i=0;i<client_num;i++){
			pop.put(new URL("http://192.168.101.103:8088/statisticsVisitor/BarNotice.html?"));
		}


		ExecutorService exec = Executors.newCachedThreadPool();

		// 50个线程可以同时访问

		final Semaphore semp = new Semaphore(thread_num);

		// 模拟2000个客户端访问

		for (int index = 0; index < client_num; index++) {

			final int NO = index;

			Runnable run = new Runnable() {

				public void run() {
					URL url = null;
					for(int i=0;i<thread_num;i++){
						try {

							// 获取许可

							semp.acquire();

							System.out.println("Thread:" + NO);

							String host = "http://192.168.101.103:8088/statisticsVisitor/BarNotice.html?";//"http://10.99.23.42:7001/KMQueryCenter/query.do?";

							String para = "upType=pvType&barId=10003&cityId=0571&visType=1&visId=34543";//"method=getQueryResult&pageNum=1&pageSize=5&"

								//+ "queryKeyWord="

								//+ getRandomSearchKey(NO)

								//+ "&questionID=-1&questionIdPath=-1&searchType=1"

								//+ "&proLine=&proSeries=&proType=" + NO;

							System.out.println(host + para);

							//URL url = new URL(host);// 此处填写供测试的url

							//HttpURLConnection connection = (HttpURLConnection) url

							//.openConnection();
							url = (URL)pop.takeFirst();
							HttpURLConnection connection = (HttpURLConnection)url.openConnection();

							// connection.setRequestMethod("POST");

							// connection.setRequestProperty("Proxy-Connection",

							// "Keep-Alive");

							connection.setDoOutput(true);

							connection.setDoInput(true);

							PrintWriter out = new PrintWriter(connection

							.getOutputStream());

							out.print(para);

							out.flush();

							out.close();

							BufferedReader in = new BufferedReader(

							new InputStreamReader(connection

							.getInputStream()));

							String line = "";

							String result = "";

							while ((line = in.readLine()) != null) {

								result += line;

							}

							// System.out.println(result);

							// Thread.sleep((long) (Math.random()) * 1000);

							// 释放

							System.out.println("第：" + NO + " 个");

							semp.release();

						} catch (Exception e) {

							e.printStackTrace();

						}finally{
							if(url != null){
								try {
									pop.put(url);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}

				}

			};

			exec.execute(run);

		}

		// 退出线程池

		exec.shutdown();

	}

	private static String getRandomSearchKey(final int no) {

		String ret = "";

		ret = ret.substring(0, ret.lastIndexOf("="));

		System.out.println("\t" + ret);

		return ret;

	}

}