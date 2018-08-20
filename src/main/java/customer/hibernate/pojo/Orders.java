package customer.hibernate.pojo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue
	private int orderId;
	private Date orderDate;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_Id")
	private List<OrderItems> ol;
	public Orders(Date ld) {		
		ol= new ArrayList<>();		
		this.orderDate = ld;
			}
	public void display() {		
		for (OrderItems orderItems : ol) {
			System.out.println(orderItems);
		}
	}
	
}
