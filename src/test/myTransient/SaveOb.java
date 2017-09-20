package test.myTransient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SaveOb {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PersistOb ob = new PersistOb();
		ob.setName("hxc316");
//		saveOb(ob);
		readOb();
	}
	
	private static void saveOb(Object ob) throws IOException{
		FileOutputStream outStream = new FileOutputStream(new File("F:\\object.txt"));
		ObjectOutputStream obOut = new ObjectOutputStream(outStream);
		obOut.writeObject(ob);
	}
	
	private static void readOb() throws IOException, ClassNotFoundException{
		FileInputStream instream = new FileInputStream(new File("F:\\object.txt"));
		ObjectInputStream obInStream = new ObjectInputStream(instream);
		PersistOb ob = (PersistOb) obInStream.readObject();
		System.out.println(ob.getName());
	}
}
