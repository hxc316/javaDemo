package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageIODemo extends Thread {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		URL url = new URL("http://imgsrc.baidu.com/forum/pic/item/3141ccbfad07932719d81fa9.jpg");
		InputStream inStream = url.openStream();
//		BufferedImage image = ImageIO.read(inStream);
//		int width = image.getWidth();  	//ͼƬ�Ŀ��
//		int height = image.getHeight();	//ͼƬ�ĸ߶�
//		out(image.getType());
		File imageFile = new File("D:/xiao_S.jpg");
		FileOutputStream fileOut = new FileOutputStream(imageFile);
		
		int b = inStream.read();
//		byte[] b = null;
		if(b != -1){
			b = inStream.read();
			out(b);
			fileOut.write(b);
		}
		inStream.close();
		fileOut.flush();
		fileOut.close();
		out("end");
	}
	
	public static void out(Object o){
		System.out.println(o);
	}

}
