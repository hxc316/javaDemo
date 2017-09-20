package junitTest.junit;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junitTest.pojo.Order;

public class OrederJunit extends TestCase{
	
	Order order_1 = new Order(1, 1.1);
	Order order_2 = new Order(2,1.2);

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		order_1.addOrder(order_2);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddOrder(){
		Order rsOrder = new Order(1,2.3);
		Assert.assertTrue(rsOrder.getOrderid().intValue() == order_1.getOrderid().intValue());
		
	}
	
	public static Test suite(){	
		return new TestSuite(OrederJunit.class);
	}
	
	
	public static void main(String[] args) {
		TestCase test = new OrederJunit();
	}
}
