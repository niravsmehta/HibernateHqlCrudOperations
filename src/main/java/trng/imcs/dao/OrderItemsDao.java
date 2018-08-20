package trng.imcs.dao;

import customer.hibernate.pojo.OrderItems;

public interface OrderItemsDao {

	OrderItems getOrderItems(int id);

	OrderItems createOrderItems(OrderItems emp);

	OrderItems updateOrderItems(OrderItems emp);

	boolean deleteOrderItems(int id);
}
