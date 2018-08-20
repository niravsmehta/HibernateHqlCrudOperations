package customer.hibernate.pojo;

// default package
// Generated Aug 6, 2018 7:40:36 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Embeddable
public class Address implements java.io.Serializable {

	private String street1;
	private String street2;
	private int zipcode;

	public Address() {

	}

	@Override
	public String toString() {
		return "Address [street1=" + street1 + ", street2=" + street2 + ", zipcode=" + zipcode + "]";
	}

	public Address(String street1, String street2, int zipcode) {
		this.street1 = street1;
		this.street2 = street2;
		this.zipcode = zipcode;
	}
	

	@Column(name = "street1", nullable = false, length = 30)
	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	@Column(name = "street2", nullable = false, length = 30)
	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	@Column(name = "zipcode", nullable = false)
	public int getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}