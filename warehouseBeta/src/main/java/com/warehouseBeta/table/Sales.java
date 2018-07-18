package com.warehouseBeta.table;
/*
 * œ˙ €
 */
public class Sales {

	private int id;
	private String name;
	private String date;
	private String operator;
	private int money;
	private String purchaser;
	

	public String getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", name=" + name + ", date=" + date + ", operator=" + operator + ", money=" + money
				+ "]";
	}
		
}
