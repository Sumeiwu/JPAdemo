package database.entity;
import javax.persistence.*;

@Entity
@Table(name="userrole")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	
	@Column(name = "userid")
    private Integer userid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "userid")
	private User userObject;
	
	@Column(name = "role")
    private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return userObject;
	}

	public void setUser(User user) {
		this.userObject = user;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userid="  + ", role=" + role + "]";
	}

	
}
