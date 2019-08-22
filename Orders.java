package assignment5;

public class Orders {
	
	Integer order_id;
	String date;
	Integer amount;
	
	
	public Orders(Integer order_id, String date, Integer amount) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.amount = amount;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
