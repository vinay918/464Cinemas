package lecture464.model;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private MovieShowing movie;
	private int quantity;
	private double orderPrice;
	private int isCancel;
	public OrderItem() {
		super();
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public MovieShowing getMovie() {
		return movie;
	}
	public void setMovie(MovieShowing movie) {
		this.movie = movie;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}
	
	
}
