package trng.imcs.dao;

import static pojo.util.HibernateUtil.openSession;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Bean.ReportBean;
import customer.hibernate.pojo.Customer;
import customer.hibernate.pojo.OrderItems;
import customer.hibernate.pojo.Orders;
import pojo.util.ReportResultTransformer;

public class CustomerDaoImpl implements CustomerDao {

	public Customer getCustomer(int id) {
		Session session = null;
		try {
			session = openSession();
			Customer c = (Customer) session.get(Customer.class, id);
			return c;
		} finally {
			session.close();
		}
	}

	public Customer createCustomer(Customer c) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			return c;
		} catch (Exception e) {
			System.out.println(c);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return null;
	}

	public Customer updateCustomer(Customer c) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(c);
			transaction.commit();
			return c;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

		return null;
	}

	public boolean deleteCustomer(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Customer c = (Customer) session.get(Customer.class, id);
			if (c != null)
				session.delete(c);
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
	public List<Customer> getCustomers(int zipcode) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Customer where zipcode = :code ");
			query.setParameter("code", zipcode);
			List<Customer> customerList = query.list();
			return customerList;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public Map<String, Double> getSalesByMonth(int year) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Map<String, Double> map = new HashMap<String, Double>();
			Query query = session.createQuery(
					"Select Month(o.orderDate), sum(orderitems.quantity * orderitems.itemPrice)from Orders as o inner join o.ol as orderitems where year(o.orderDate)= :year group by Month(o.orderDate) ");
			query.setParameter("year", year);
			List<Object[]> orderList = query.list();
			for (Object[] row : orderList) {
				Month month = Month.of((int) row[0]);
				map.put(month.name(), (Double) row[1]);
			}
			return map;
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public List<ReportBean> getReport(int month) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			List<ReportBean> reportBeanList = null;
			Query query = session.createQuery(
					"Select c.id,c.name, sum(orderitems.quantity * orderitems.itemPrice) as total from Customer as c,Orders as o inner join c.orderList inner join o.ol as orderitems  where month(o.orderDate)= :month ");
			query.setParameter("month", month);
			ReportResultTransformer transformer = new ReportResultTransformer();
			query.setResultTransformer(transformer);
			reportBeanList = query.list();
			return reportBeanList;
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;
	}
}
