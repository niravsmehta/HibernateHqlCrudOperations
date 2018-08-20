package MainApp;

import static pojo.util.HibernateUtil.openSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import Service.CustomerService;
import Service.CustomerServiceImpl;
import customer.hibernate.pojo.Address;
import customer.hibernate.pojo.Customer;
import customer.hibernate.pojo.OrderItems;
import customer.hibernate.pojo.OrderItems.Category;
import customer.hibernate.pojo.Orders;
import pojo.util.HibernateUtil;
import trng.imcs.dao.CustomerDao;
import trng.imcs.dao.CustomerDaoImpl;
import trng.imcs.dao.OrderItemsDao;
import trng.imcs.dao.OrderItemsDaoImpl;
import trng.imcs.dao.OrdersDao;
import trng.imcs.dao.OrdersDaoImpl;

public class App {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		CustomerDao cd = new CustomerDaoImpl();
		OrdersDao ad = new OrdersDaoImpl();
		OrderItemsDaoImpl aod = new OrderItemsDaoImpl();
		CustomerService cs = new CustomerServiceImpl();
		Address a = new Address("Macarthur blvd", "Apt 3116", 75063);
		Customer c = new Customer("Nirav", 26, a);
		Customer c1 = new Customer("Nick", 27, a);
		Customer c2 = new Customer("Neil", 28, a);
		LocalDate ld = LocalDate.of(2018, 6, 7);
		LocalDate ld1 = LocalDate.of(2018, 3, 7);
		LocalDate ld2 = LocalDate.of(2018, 2, 8);
		Orders o = new Orders(java.sql.Date.valueOf(ld));
		Orders o1 = new Orders(java.sql.Date.valueOf(ld1));
		Orders o2 = new Orders(java.sql.Date.valueOf(ld2));
		OrderItems oi = new OrderItems("Corn Flakes", 3, Category.Food, 10);
		OrderItems oi1 = new OrderItems("Razor", 2, Category.General, 25);
		OrderItems oi2 = new OrderItems("Lays Chips", 5, Category.Food, 2);
		OrderItems oi3 = new OrderItems("Bayer", 2, Category.Pharmacy, 12);
		OrderItems oi4 = new OrderItems("Hippo Game", 2, Category.Toys, 46);
		OrderItems oi5 = new OrderItems("Water Bottles", 6, Category.General, 4);
		c.getOrderList().add(o);
		c1.getOrderList().add(o1);
		c2.getOrderList().add(o2);
		o.getOl().add(oi);
		o.getOl().add(oi1);
		o1.getOl().add(oi2);
		o1.getOl().add(oi3);
		o2.getOl().add(oi4);
		o2.getOl().add(oi5);
		// Performing CRUD Operations
		cd.createCustomer(c);
		cd.createCustomer(c1);
		cd.createCustomer(c2);
		List<Customer> customerList = new ArrayList<>();
		customerList = cd.getCustomers(75063);
		List<Orders> ordersList = new ArrayList<>();
		for (Customer cc : customerList) {
			System.out.println(cc);
		}
		ad.deleteOrders(1);
		Address a1 = new Address("Henessy Blvd", "Apt 3186", 75062);
		Customer cUpdate = new Customer("Nick", 26, a1);
		cd.updateCustomer(cUpdate);
		Orders orderUpdate = new Orders(java.sql.Date.valueOf(ld));
		ad.updateOrders(orderUpdate);

		// Hql Implementations
		cs.displayCustomers(75063);
		cs.displayMonthlySales(2018);
		cs.displayGetReport(6);
		ad.getOrdersByTotalPrice(20);

	}

}
