package designed.chain.demo1.inter;

import designed.chain.demo1.BaseFilter;

public class AuthFilter extends BaseFilter{

	@Override
	public void exeFilter() {
		System.out.println("---------do other things  ----------");
		doNextFilter();
		System.out.println("------------ do other things ------------");
	}

}
