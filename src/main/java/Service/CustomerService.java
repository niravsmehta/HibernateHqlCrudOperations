package Service;

public interface CustomerService {
	public void displayCustomers(int zipcode);
	public void displayMonthlySales(int year);
	public void displayGetReport(int month);
	public void displayOrders(double totalPrice);
}
