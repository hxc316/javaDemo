package test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;
/**
 * 
 * 功能：发送和接受数据包 
 *
 */
public class SocketTest {

	public void socketTest() {
		InetSocketAddress inetSocket = InetSocketAddress.createUnresolved(
				"127.0.0.1", 8083);
		Socket socket = null;
		try {

			socket = new Socket("127.0.0.1", 8083);
			SocketAddress socketAddress = new InetSocketAddress(8083);
			socket.connect(socketAddress);
			// socket.

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		Integer port = 8081;
		byte[] buffer = new byte[2048];
		try {
			/**
			 * 发送和接收数据报包的套接字
			 */
			DatagramSocket datagramSocket = new DatagramSocket(port);
			DatagramPacket datagramPacket = new DatagramPacket(buffer,
					buffer.length);

			for (;;) {

				System.out.println("begin receive data....");

				datagramSocket.receive(datagramPacket);

				System.out.println(datagramPacket.getAddress().getAddress()
						.toString()
						+ "=======" + new String(datagramPacket.getData()));

				datagramPacket.setLength(datagramPacket.getData().toString()
						.length());
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3(){
		try {
			for (int i=0;i<2;i++) {
				
				DatagramSocket sendSocket = new DatagramSocket();
	
				DatagramPacket dataPack = new DatagramPacket(
	
				"hello ,welcome to study java..".getBytes(),
	
				"hello ,welcome to study java..".length(), InetAddress.getByName("127.0.0.1"), new Integer(8081));
				sendSocket.send(dataPack);
				sendSocket.close();
				
				Thread.sleep(1000);
			}
			} catch (Exception e) {
				e.printStackTrace();

			}finally{
				System.out.println(111);
			}
	}
}
