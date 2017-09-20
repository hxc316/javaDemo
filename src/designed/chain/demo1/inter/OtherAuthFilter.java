package designed.chain.demo1.inter;

import designed.chain.demo1.BaseFilter;

public class OtherAuthFilter extends BaseFilter{

	@Override
	public void exeFilter() {
		System.out.println("---------rewrite url ----------");
		doNextFilter();
		System.out.println("------------ rewrite url ------------");
	}

}
