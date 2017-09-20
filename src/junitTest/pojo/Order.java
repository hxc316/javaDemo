package junitTest.pojo;

public class Order {
	
	private Integer orderid;
	private Double money;
	
	
	public Order() {
		super();
	}
	public Order(Integer orderid, Double money) {
		super();
		this.orderid = orderid;
		this.money = money;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
	public Order addOrder(Order order){
		this.setMoney(order.getMoney());
		return this;
	}
}
