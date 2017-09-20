package designed.chain.demo1;

import designed.chain.demo1.inter.AuthFilter;
import designed.chain.demo1.inter.OtherAuthFilter;
import designed.chain.demo1.inter.ReWriteFilter;

public class MainChain {

	public static void main(String[] args) {
		doChain();
	}
	
	public static void doChain(){
		AuthFilter f1 = new AuthFilter();
		ReWriteFilter f2 = new ReWriteFilter();
		OtherAuthFilter f3 = new OtherAuthFilter();
		
		f1.setNextFilter(f2);
		f2.setNextFilter(f3);
		f1.exeFilter();
		
	}
}
