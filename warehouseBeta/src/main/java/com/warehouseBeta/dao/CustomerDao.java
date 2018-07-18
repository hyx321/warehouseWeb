package com.warehouseBeta.dao;

import java.util.List;

import com.warehouseBeta.table.Customer;
import com.warehouseBeta.table.Sales;

public interface CustomerDao {
	
	//��ȡ���пͻ�����Ϣ
	List<Customer> getAllCustomerInformation();
	
	//���¿ͻ�����Ϣ
	void updateCustomerInformation(Customer customer);
	
	//ɾ���ͻ�����Ϣ
	void deleteCustomerInformation(int ID);
	
	//����/����ͻ�����Ϣ
	void insertCustomerInformation(Customer customer);
	
	//��ȡ�ͻ���Ϣ
	List<Customer> getCustomerInformation(int ID);
	
	//��ȡ���׼�¼
	List<Sales> getSaleInformation(String purchaser);

	//��ȡ�ͻ�������
	List<Customer> getAllCustomerName();
	
}
