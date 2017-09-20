package designed.strategy.demo1.priceStrategy;

import designed.strategy.demo1.CountPrice;
/**
 *	打折收费类
 */
public class PriceDiscount extends CountPrice {
	
	private double disCount;

	public PriceDiscount(double disCount){
		this.disCount = disCount;
	}
	
	@Override
	public double getPrice(double price) {
		return price * disCount;
	}

}
