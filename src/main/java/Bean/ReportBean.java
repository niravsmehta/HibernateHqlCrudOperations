package Bean;

/**
 * @author Nirav
 *
 */
public class ReportBean {

	int customerId;
	String customerName;
	double TotalOrderPrice;

	public double getTotalOrderPrice() {
		return TotalOrderPrice;
	}

	public void setTotalOrderPrice(double totalOrderPrice) {
		TotalOrderPrice = totalOrderPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "ReportBean [customerId=" + customerId + ", customerName=" + customerName + ", TotalOrderPrice="
				+ TotalOrderPrice + "]";
	}
	

}
