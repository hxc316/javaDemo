package file.writeFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class WriteFile{
	
	/**
	 * 文件流刷新的时间
	 */
	 private final static long FLUSH_INVALID_TIME = 24 * 60 * 1000 ;
	 private static long last_flush_time = 0;
	 
	 
	private static String statData = "最初java是不支持对文本文件的处理的，为了弥补这个缺憾而引入了Reader和Writer两个类，这两个类都是抽象类，Writer中 write(char[] ch,int off,intlength)，flush()和close()方法为抽象方法，Reader中read(char[] ch,int off,int length)和close()方法是抽象方法。子类应该分别实现他们。";
	private static String[] files = {"aa","bb","cc","dd","ee","ff","hh","ii","jj","kk"};
	
	Map<String,FileWriter> fileWrites = new HashMap<String, FileWriter>();
	
	public static void main(String[] args) throws IOException {
		String data = "最初java是不支持对文本文件的处理的，为了弥补这个缺憾而引入了Reader和Writer两个类，这两个类都是抽象类，Writer中 write(char[] ch,int off,intlength)，flush()和close()方法为抽象方法，Reader中read(char[] ch,int off,int length)和close()方法是抽象方法。子类应该分别实现他们。";
		long begin = System.currentTimeMillis();
		Random random = new Random();
		WriteFile write = new WriteFile();
		for(int i=0;i<100000;i++){
			write.writeData(files[random.nextInt(10)]);
		}
		write.flushWriter();
		System.out.println("need time :"+(System.currentTimeMillis()-begin));
	}
	
	/**
	 * 初始化文件流
	 * @throws IOException
	 */
	private void init() throws IOException{
		if(fileWrites.size()>0) return;
		for(String file:files){
			fileWrites.put(file, new FileWriter("d:/"+file+".txt"));
		}
	}
	
	private void flushWriter() throws IOException{
		if(fileWrites.size()==0) throw new RuntimeException("");
		Set<String> keys = fileWrites.keySet();
		for(String key:keys){
			fileWrites.get(key).flush();
		}
	}
	
	private void flushWriteWithTime() throws IOException{
		long now = System.currentTimeMillis();
		if(now - last_flush_time >FLUSH_INVALID_TIME){
			flushWriter();
			last_flush_time = now;
		}
	}
	
	/**
	 * 根据siteID往各自文件写数据
	 * @param siteId
	 * @throws IOException
	 */
	public void writeData(String siteId) throws IOException{
		init();
		FileWriter writer = fileWrites.get(siteId);
		writer.write(statData);
	}
	
}
