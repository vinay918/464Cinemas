package lecture464.databaseAccessLayer;

import java.util.ArrayList;

import lecture464.model.*;

public class OrdersDB {

	public void addOrderItem(int orderId, int showingId, int quantity, double totalPrice) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addOrderItem(showingId, quantity, orderId, totalPrice);
		db.closeConnection();
	}
	
	public ArrayList<Orders> getUserOrders(int userId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		ArrayList<Orders> orders = new ArrayList<Orders>();
		orders = db.getOrders(userId);
		db.closeConnection();
		return orders;
	}
	
	public ArrayList<OrderItem> getOrderItems(int orderId){
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		ArrayList<OrderItem> items = new ArrayList<OrderItem>();
		items = db.getOrderItems(orderId);
		db.closeConnection();
		return items;
	}
	
	public void addOrder(int orderId, int userId, double totalCost, String orderDate, String billingAddress, String creditCardNumber) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.addOrder(orderId, userId, totalCost, orderDate, billingAddress, creditCardNumber);
		db.closeConnection();
	}
	
	public double getOrderItemPrice(int orderItemId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		double price = db.getOrderItem(orderItemId).getOrderPrice();
		db.closeConnection();
		return price;
	}
	
	public void setCancelOrderItem(int orderItemId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.setCancelOrderItem(orderItemId);
		db.closeConnection();
	}
	
	public OrderItem getOrderItem(int orderItemId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		OrderItem item = db.getOrderItem(orderItemId);
		db.closeConnection();
		return item;
	}
	
}
