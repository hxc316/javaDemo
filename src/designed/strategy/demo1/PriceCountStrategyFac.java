package designed.strategy.demo1;

import designed.strategy.demo1.priceStrategy.PriceDiscount;
import designed.strategy.demo1.priceStrategy.PriceNormal;
import designed.strategy.demo1.priceStrategy.PriceReturnCash;

public class PriceCountStrategyFac {
	
	/**
	 * 获取收费策略 
	 * @param type
	 * @return
	 */
	public static CountPrice getStrategy(Integer type){
		switch(type){
			case 1:		//正常收费
				return new PriceNormal();
			case 2:		//打折收费
				return new PriceDiscount(0.8);
			case 3:		//返利收费
				return new PriceReturnCash(300, 100);
		}
		throw new RuntimeException("收费类型错误");
	}

}
