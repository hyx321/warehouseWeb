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
	
	//��ȡ���пͻ�����Ϣ
	@Override
	public List<Customer> getAllCustomerInformation() {
		
		return customerDao.getAllCustomerInformation();
	}

	//���¿ͻ�����Ϣ
	@Override
	public void updateCustomerInformation(Customer customer) {
		
		customerDao.updateCustomerInformation(customer);	
	}
	
	//ɾ���ͻ�����Ϣ
	@Override
	public void deleteCustomerInformation(int ID) {
		
		customerDao.deleteCustomerInformation(ID);
	}

	//�����ͻ�
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
