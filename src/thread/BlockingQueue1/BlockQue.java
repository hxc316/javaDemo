package thread.BlockingQueue1;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import junit.framework.Assert;

import org.junit.Test;

public class BlockQue {
	
	/**
	 * 这个符合先进先近先出的原则
	 */
	Queue<Integer> intQue = new LinkedList<Integer>();
	
	/*
	 * 这个会自动排序 不会先进后出
	 */
	Queue<String> strQue = new PriorityQueue<String>();
	
	@Test
	public void testA(){
		for(int i =1;i<10;i++){
			intQue.add(i);
		}
		
		System.out.println(intQue.poll());
		
		System.out.println(Arrays.asList(intQue));
		Assert.assertEquals("[[2, 3, 4, 5, 6, 7, 8, 9]]", ""+Arrays.asList(intQue));
	
	}
	@Test
	public void testB(){
		strQue.add("bb");
		strQue.add("aa");
		strQue.add("cc");
		strQue.add("1");
		strQue.add("超");
		Iterator<String> it = strQue.iterator();
		while(it.hasNext()){
			System.out.println(it.next());;
		}
		
	}
}
