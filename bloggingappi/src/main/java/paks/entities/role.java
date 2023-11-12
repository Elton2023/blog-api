package paks.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class role {
	@Id
 	private int id;
	
	private   String name;
	
	
	@ManyToMany
	private Set<User> Users;


	public role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public role(int id, String name, Set<User> users) {
		this.id = id;
		this.name = name;
		Users = users;
	}

	public role(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public role(String name, Set<User> users) {
		this.name = name;
		Users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return Users;
	}

	public void setUsers(Set<User> users) {
		Users = users;
	}
}
