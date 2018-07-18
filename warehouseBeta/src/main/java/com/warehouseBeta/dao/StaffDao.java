package com.warehouseBeta.dao;

import java.util.List;

import com.warehouseBeta.table.Customer;
import com.warehouseBeta.table.Staff;


public interface StaffDao {
	
	//��ȡ����Ա������Ϣ
	List<Staff> getAllStaffInformation();
	
	//�鿴������˺��Ƿ���ȷ
	String checkStaffInformation(String name);
	
	//����Ա������Ϣ
	void updateStaffInformation(Staff staff);
	
	//ɾ��Ա������Ϣ
	void deleteStaffInformation(int ID);
	
	//����/����Ա������Ϣ
	void insertStaffInformation(Staff staff);

	//��ȡԱ����Ϣ
	List<Staff> getStaffInformation(int ID);
	
	//��ȡ����Ա��������
	List<Staff> getAllStaffName();
}
