package com.warehouseBeta.table;
/*
 * Ô±¹¤
 */
public class Staff {
	
	private int id;
	private String name;
	private String address;	
	private String telephone;
	private String password;

	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", address=" + address + ", telephone=" + telephone
				+ ", password=" + password + "]";
	}
	
}
