package test.gamebar.privillege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 版权所有：顺网科技 保留所有权利
 * date: 2012-4-30
 * author：huxinchao
 * 功能：过滤网吧条件
 *
 */
public class BarIdSel {
	
	List<String[]> sqlList = new ArrayList<String[]>();
	
	
	
	public void init(){
		String s[] = {"",""};
		sqlList.add(s);
	}
	
	public static void main(String[] args) {
		List<Integer> barIds = new ArrayList<Integer>();
		long begin = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			barIds.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
	

}
