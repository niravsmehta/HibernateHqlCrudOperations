package customer.hibernate.pojo;

import java.util.List;
import java.util.Locale.Category;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItems {
	@Id
	@GeneratedValue
	private int orderItemId;
	private String itemName;
	private double itemPrice;
	private int quantity;
	@Enumerated(EnumType.STRING)
	private Category category;
	

	public OrderItems(String itemName, int quantity, Category category, double itemPrice) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.category = category;
		this.itemPrice=itemPrice;
	}


	public enum Category {
		Toys, Food, Pharmacy, General;
	}

}
