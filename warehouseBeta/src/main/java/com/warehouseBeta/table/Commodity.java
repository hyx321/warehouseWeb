package com.warehouseBeta.table;

/*
 * 商品信息
 */
public class Commodity {

	private int id;
	private String name;
	private String origin;
	private String supplier;
	private String remark;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + ", origin=" + origin + ", supplier=" + supplier + ", remark="
				+ remark + "]";
	}
}
