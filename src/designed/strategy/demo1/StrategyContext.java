package designed.strategy.demo1;

import designed.strategy.demo1.priceStrategy.PriceDiscount;
import designed.strategy.demo1.priceStrategy.PriceNormal;
import designed.strategy.demo1.priceStrategy.PriceReturnCash;
/**
 *	策略上下文 
 */
public class StrategyContext {
	
	private CountPrice countPrice;
	
	public StrategyContext(Integer type){
		switch(type){
			case 1:
				countPrice = new PriceNormal();
				break;
			case 2:
				countPrice = new PriceDiscount(0.8);
				break;
			case 3:
				countPrice = new PriceReturnCash(300, 100);
				break;
		}
	}
	
	public double getCountPrice(double price){
		return countPrice.getPrice(price);
	}

}
