package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Bean.ReportBean;
import customer.hibernate.pojo.Customer;
import customer.hibernate.pojo.Orders;
import trng.imcs.dao.CustomerDao;
import trng.imcs.dao.CustomerDaoImpl;
import trng.imcs.dao.OrdersDao;
import trng.imcs.dao.OrdersDaoImpl;

/**
 * @author Nirav
 *
 */
public class CustomerServiceImpl implements CustomerService {

	CustomerDao cd = new CustomerDaoImpl();
	OrdersDao od = new OrdersDaoImpl();

	@Override
	public void displayCustomers(int zipcode) {
		List<Customer> customerList = cd.getCustomers(zipcode);
		customerList.stream().forEach(System.out::println);
	}

	@Override
	public void displayMonthlySales(int year) {
		Map<String, Double> map = cd.getSalesByMonth(year);
		map.forEach((k, v) -> {
			System.out.println("Month : " + k + " TotalSales: " + v);
		});
	}

	@Override
	public void displayGetReport(int month) {
		List<ReportBean> list = cd.getReport(month);
		list.forEach((e) -> System.out.println(e));
	}

	@Override
	public void displayOrders(double totalPrice) {
		List<Orders> orderList = od.getOrdersByTotalPrice(totalPrice);
		orderList.forEach(System.out::println);
	}

}
