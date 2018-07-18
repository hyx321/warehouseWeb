package com.warehouseBeta.service;

import java.util.List;

import com.warehouseBeta.table.Customer;
import com.warehouseBeta.table.Sales;

public interface CustomerService {

	//获取所有客户的信息
	List<Customer> getAllCustomerInformation();

	//更新客户的信息
	void updateCustomerInformation(Customer customer);
	
	//删除客户的信息
	void deleteCustomerInformation(int ID);
	
	//新增/插入客户的信息
	void insertCustomerInformation(Customer customer);
	
	//获取客户信息
	List<Customer> getCustomerInformation(int ID);
	
	//获取交易记录
	List<Sales> getSaleInformation(String purchaser);

	//获取所有客户的名字
	List<Customer> getAllCustomerName();
}

