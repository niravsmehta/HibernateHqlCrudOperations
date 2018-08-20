package trng.imcs.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static pojo.util.HibernateUtil.openSession;

import java.util.List;

import customer.hibernate.pojo.Customer;
import customer.hibernate.pojo.Orders;

public class OrdersDaoImpl implements OrdersDao {

	public Orders getOrders(int id) {
		Session session = null;
		try {
			session = openSession();
			Orders o = (Orders) session.get(Orders.class, id);
			return o;
		} finally {
			session.close();
		}
	}

	public Orders createOrders(Orders o) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
			return o;
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return null;
	}

	public Orders updateOrders(Orders o) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(o);
			transaction.commit();
			return o;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return null;
	}

	public boolean deleteOrders(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Orders o = (Orders) session.get(Orders.class, id);
			if (o != null)
				session.delete(o);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Orders> getOrdersByTotalPrice(double totalPrice) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(
					"Select o.id,o.orderDate from Orders as o inner join o.ol as orderitems  where (orderitems.quantity * orderitems.itemPrice)> :totalPrice ");
			query.setParameter("totalPrice", totalPrice);
			List<Orders> orderList = query.list();
			return orderList;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;

	}

}
