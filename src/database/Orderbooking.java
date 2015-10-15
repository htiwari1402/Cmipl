package database;

public class Orderbooking {
	
	public String retailer;
	public String  product;
	public int order;
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Orderbooking(String retailer, String product, int order) {
		super();
		this.retailer = retailer;
		this.product = product;
		this.order = order;
	}

	

	

}
