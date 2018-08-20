package trng.imcs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import customer.hibernate.pojo.OrderItems;

import static pojo.util.HibernateUtil.openSession;



public class OrderItemsDaoImpl implements OrderItemsDao {

	public OrderItems getOrderItems(int id) {
		Session session = null;
		try {
			session = openSession();
			OrderItems o = (OrderItems) session.get(OrderItems.class, id);
			return o;
		} finally {
			session.close();
		}
	}

	public OrderItems createOrderItems(OrderItems o) {
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

	public OrderItems updateOrderItems(OrderItems o) {
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

	public boolean deleteOrderItems(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			OrderItems o = (OrderItems) session.get(OrderItems.class, id);
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

	
	}


