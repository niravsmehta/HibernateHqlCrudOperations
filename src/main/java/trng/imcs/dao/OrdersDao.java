package trng.imcs.dao;

import java.util.List;

import customer.hibernate.pojo.Orders;

public interface OrdersDao {

	Orders getOrders(int id);

	Orders createOrders(Orders emp);

	Orders updateOrders(Orders emp);

	boolean deleteOrders(int id);

	List<Orders> getOrdersByTotalPrice(double totalPrice);
}
