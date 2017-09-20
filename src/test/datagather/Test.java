package test.datagather;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.commons.io.FileUtils;

import junit.framework.TestCase;


public class Test extends TestCase{
/*	
	public void test1(){
		try {
			FileWriteSize f1 = new FileWriteSize("d:/tt/a.txt");
			FileWriteSize f2 = new FileWriteSize("d:/tt/b.txt");
			
			f1.write("aa");
			f2.write("bb");
			f1.flush();
			f2.flush();
			f1.close();
			f2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test2(){
		try {
			FileWriterWithEncoding ff = new FileWriterWithEncoding("d:/tt/test2.txt","Gbk",true);
			ff.write("ssfsfs失敬失敬");
			ff.flush();
			ff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
	public void test3(){
		File file = new File("d:/tt/tt1.txt");
		try {
			// 可以设置编码 
			String str = "aaas萨克斯开始";
			byte[] btyes = str.getBytes();
			String str2 = new String(btyes,"gbk");
			System.out.println(str2);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "gbk"), 8192);
			out.write(str2);
			out.flush();
			out.close();
			
//			FileWriter writer = new filew
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			
		}
	}
	
	public void test4(){
		try {
			FileWriter writer = new FileWriter("d:/tt/test4.txt");
			String aa = "aaa啊";
			System.out.println(aa.getBytes());
			byte[] buffer = aa.getBytes();
			String str = new  String(buffer,"gb2312");// 系统默认是utf-8  这样乱码
			System.out.println(str);
//			System.out.println(Charset.defaultCharset());
			writer.write(str);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 循环 break 
	public void test5(){
		for(int i=0;i<10;i++){
			System.out.println(i);
			if(i>3){
				break;
			}
		}
	}

	public void test6(){
		long begin = System.currentTimeMillis();
		for(int i=0;i<100000000;i++){
			long time = System.currentTimeMillis();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
	/**
	 * InetAddress 主机名
	 */
	public void test7(){
		try {
			InetAddress inetAddress= InetAddress.getLocalHost();
			System.out.println(inetAddress.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		};
	}
	
	public void test8(){
		Timestamp date = new Timestamp(System.currentTimeMillis());
		System.out.println(date.toString().replace("-","").replace(":","_").replace(" ","").substring(0,13));
	}
	
	public void test9(){
		long NEW_FILE_TIME = 1 * 60 * 60 * 1000;
		Double time = 0.5;
		NEW_FILE_TIME = (long) (time * NEW_FILE_TIME);
		System.out.println(NEW_FILE_TIME);
	}
	/**
	 * break 线程结束 
	 */
	public void test10(){
		new Thread(){
			public void run(){
				int i = 0;
				while(true){
					i++;
					if(i>1000){
						System.out.println(i);
						break;
					}
				}
			}
		}.start();
	}
	
	public void test11(){
//		String str = "aa胡";
//		System.out.println(Charset.defaultCharset().name());  // 默认字符集
		try {
			String str = "aa胡";
			System.out.println(str.getBytes("utf-8").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public void test12() throws IOException{
	        ByteBuffer buffer = ByteBuffer.allocate(1024);
	        Selector selector = Selector.open();
	        ServerSocketChannel ssc = ServerSocketChannel.open();
	        ssc.configureBlocking(false);//设置为非阻塞方式
	        ssc.socket().bind(new InetSocketAddress(8080));
	        ssc.register(selector, SelectionKey.OP_ACCEPT);//注册监听的事件
	        while (true) {
	            Set selectedKeys = selector.selectedKeys();//取得所有key集合
	            Iterator it = selectedKeys.iterator();
	            while (it.hasNext()) {
	                SelectionKey key = (SelectionKey) it.next();
	                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
	                    ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
	                 SocketChannel sc = ssChannel.accept();//接受到服务端的请求
	                    sc.configureBlocking(false);
	                    sc.register(selector, SelectionKey.OP_READ);
	                    it.remove();
	                } else if 
	                ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
	                    SocketChannel sc = (SocketChannel) key.channel();
	                    while (true) {
	                        buffer.clear();
	                        int n = sc.read(buffer);//读取数据
	                        if (n <= 0) {
	                            break;
	                        }
	                        buffer.flip();
	                    }
	                    it.remove();
	                }
	            }
	        }
	}
	
	
	public void test14(){
		LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque();
		try {
				deque.put(1);
				deque.put(2);
				deque.put(3);
				System.out.println(deque.poll());
				System.out.println("size:"+ deque.size());
				System.out.println(deque.poll());
				System.out.println("size:"+ deque.size());
				System.out.println(deque.poll());
				System.out.println(deque.poll());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void test15(){
		long i = 0;
		for(;;){
			i++;
		}
	}
	
	public void test16(){
		//目标地址是 ?
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		String str = new String("aa");
		try {
			byteOut.write(str.getBytes());
			byteOut.flush();
			System.out.println(byteOut.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 写字节和写字符效率的区别 
	 */
	public void test17(){
		System.out.println("begin...");
		long begin = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			/**
			 * 输出字节要比输出字符快 
			 */
//			System.out.println("System.out.println(byteOut.toByteArray());".getBytes());
			System.out.println("System.out.println(byteOut.toByteArray())");
		}
		System.out.println("over... ;time: "+( System.currentTimeMillis() - begin));
	}
	
	public void test18(){
		String str = "aa啊";
		System.out.println(str.length());
		try {
			/**
			 * 
			 */
			System.out.println(str.getBytes("GB2312").length);	// 4个字节
			System.out.println(str.getBytes("GBK").length);	// 4个字节
			System.out.println(str.getBytes("utf-8").length);	// 5个字节 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
// ----- begin test
	public void test19(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		System.out.println("begin : "+list.size());
//		test19_add(list);
		test19_(list);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end : "+list.size());
	}
	public void test19_(final ArrayList<String> a){
		new Thread(new Runnable() {
			@Override
			public void run() {
//				test19_add(a);
			}
		}).start();
	}
	
	
	
// ---------end test 
	
	public static void main(String[] args) {
		Test test = new Test();
		try {
			test.test12();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(Charset.defaultCharset().name());
		
	}

}
