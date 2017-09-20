package designed.chain.demo1.inter;

import designed.chain.demo1.BaseFilter;

public class ReWriteFilter extends BaseFilter{

	@Override
	public void exeFilter() {
		System.out.println("---------chek user ----------");
		doNextFilter();
		System.out.println("------------ check user ------------");
	}

}
