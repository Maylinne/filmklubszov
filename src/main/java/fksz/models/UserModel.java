package fksz.models;

import java.util.ArrayList;


public class UserModel extends BaseModel{
	
	private int id;
	private String email;
	private String name;
	private String password;
	private String role;
	private String guid;
	private String status;
	private String lastLogin;
	@SuppressWarnings("unused")
	private ArrayList<String> availableRoles;
	
	public UserModel() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getAvailableRoles() {
		ArrayList<String> availableRoles = new ArrayList<>();
		availableRoles.add("ROLE_ADMIN");
		availableRoles.add("ROLE_ORGANIZER");
		availableRoles.add("ROLE_VENDOR");
		return availableRoles;
	}

	public void setAvailableRoles(ArrayList<String> availableRoles) {
		this.availableRoles = availableRoles;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




}
