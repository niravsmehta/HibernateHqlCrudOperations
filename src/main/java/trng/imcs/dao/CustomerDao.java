package trng.imcs.dao;

import java.util.List;
import java.util.Map;

import Bean.ReportBean;
import customer.hibernate.pojo.Customer;
import customer.hibernate.pojo.Orders;

public interface CustomerDao {

	Customer getCustomer(int id);

	Customer createCustomer(Customer emp);

	Customer updateCustomer(Customer emp);

	boolean deleteCustomer(int id);

	public List<Customer> getCustomers(int zipcode);

	public Map<String, Double> getSalesByMonth(int year);

	public List<ReportBean> getReport(int month);
}
