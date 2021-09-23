package database.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="users")
@NamedQuery(query = "SELECT u FROM User u WHERE u.id = :id", name = "findByPK")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "fullName")
    private String fullName; 
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "addressLine1")
    private String addressLine1;
	
	@Column(name = "addressLine2")
    private String addressLine2;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "state")
    private String state;
	
	@Column(name = "phone")
    private String phone;

	public Integer getId() {
		return id;
	}

//	@Basic(fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "userObject",
     orphanRemoval = true,
     fetch = FetchType.LAZY,
     cascade = CascadeType.ALL)
	private List<UserRole> userRoles = new ArrayList<UserRole>();
	
	@ManyToMany(mappedBy = "users")
	private List<Product> products = new ArrayList<Product>();
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", fullName=" + fullName + ", password=" + password
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", phone=" + phone +  "]";
	}

	
}