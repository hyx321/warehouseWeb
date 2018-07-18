package com.warehouseBeta.table;
/*
 * ½»Ò×¼ÇÂ¼
 */
public class Transaction {

	private int id;
	private String name;
	private int count;
	private int money;
	private String date;
	private String operator;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
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
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", name=" + name + ", count=" + count + ", money=" + money + ", date=" + date
				+ ", operator=" + operator + "]";
	}
	
}
