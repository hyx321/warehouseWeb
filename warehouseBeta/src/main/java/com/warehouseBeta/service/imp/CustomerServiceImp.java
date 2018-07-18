package com.warehouseBeta.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouseBeta.dao.CustomerDao;
import com.warehouseBeta.service.CustomerService;
import com.warehouseBeta.table.Customer;
import com.warehouseBeta.table.Sales;

@Service
public class CustomerServiceImp implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	//获取所有客户的信息
	@Override
	public List<Customer> getAllCustomerInformation() {
		
		return customerDao.getAllCustomerInformation();
	}

	//更新客户的信息
	@Override
	public void updateCustomerInformation(Customer customer) {
		
		customerDao.updateCustomerInformation(customer);	
	}
	
	//删除客户的信息
	@Override
	public void deleteCustomerInformation(int ID) {
		
		customerDao.deleteCustomerInformation(ID);
	}

	//新增客户
	@Override
	public void insertCustomerInformation(Customer customer) {
		
		customerDao.insertCustomerInformation(customer);
	}

	@Override
	public List<Customer> getCustomerInformation(int ID) {
		
		return customerDao.getCustomerInformation(ID);
	}

	@Override
	public List<Sales> getSaleInformation(String purchaser) {
		// TODO Auto-generated method stub
		return customerDao.getSaleInformation(purchaser);
	}

	@Override
	public List<Customer> getAllCustomerName() {
	
		return customerDao.getAllCustomerName();
	}


}
