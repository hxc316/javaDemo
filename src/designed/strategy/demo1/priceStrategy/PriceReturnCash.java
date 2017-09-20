package designed.strategy.demo1.priceStrategy;

import designed.strategy.demo1.CountPrice;
/**
 *	返利策略
 */
public class PriceReturnCash extends CountPrice {
	
	private double sumCount;
	private double returnCount;
	
	public PriceReturnCash(double sumCount,double returnCount){
		this.sumCount = sumCount;
		this.returnCount  = returnCount;
	}
	@Override
	public double getPrice(double price) {
		if(price >= sumCount)
			return price - returnCount;
		return price;
	}

}
