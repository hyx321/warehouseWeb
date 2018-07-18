package com.warehouseBeta.table;
/*
 * ¿â´æ
 */
public class Stock {
	private int id;
	private String name;
	private String origin;
	private String supplier;
	private int count;
	private String date;
	private String operator;
	private String remark;
	public int getId() {
		return id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
		return "Stock [id=" + id + ", name=" + name + ", origin=" + origin + ", supplier=" + supplier + ", count="
				+ count + ", date=" + date + ", operator=" + operator + "]";
	}
	
}
