package stream.writeOneFile;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

public class ThreadOneFile extends TestCase{
	
	public class WriteHread implements Runnable{
		public String fileName;
		
		public WriteHread(String fileName){
			this.fileName = fileName;
		}

		@Override
		public void run() {
			write();
		}
		
		public void write(){
			for(int i=0; i<100000;i++){
				try{
					FileUtils.writeStringToFile(new File(fileName), "jkskfskjkfsdjfskjdflkjsdjfslkjdflksjdlfjslkdjflksjdlkfjslkjdflksjdlkfslkdjflksjdkfsjdata"+i);
					Thread.sleep(10);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	public void test1(){
		Thread t1 = new Thread(new WriteHread("d:/t1.txt"));
		t1.start();
		Thread t2 = new Thread(new WriteHread("d:/2.txt"));
		t2.start();
		Thread t3 = new Thread(new WriteHread("d:/3.txt"));
		t3.start();
		Thread t4 = new Thread(new WriteHread("d:/4.txt"));
		t4.start();
		Thread t5 = new Thread(new WriteHread("d:/5.txt"));
		t5.start();
		Thread t6 = new Thread(new WriteHread("d:/6.txt"));
		t6.start();
		Thread t7 = new Thread(new WriteHread("d:/7.txt"));
		t7.start();
		Thread t8 = new Thread(new WriteHread("d:/8.txt"));
		t8.start();
		Thread t9 = new Thread(new WriteHread("d:/9.txt"));
		t9.start();
		Thread t10 = new Thread(new WriteHread("d:/10.txt"));
		t10.start();
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
