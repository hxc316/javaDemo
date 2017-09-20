package designed.strategy.demo1.priceStrategy;

import designed.strategy.demo1.CountPrice;
/**
 *	正常收费类
 */
public class PriceNormal extends CountPrice {

	@Override
	public double getPrice(double price) {
		return price;
	}

}
