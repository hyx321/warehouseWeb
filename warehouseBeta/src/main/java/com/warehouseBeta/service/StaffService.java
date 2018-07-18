package com.warehouseBeta.service;

import java.util.List;

import com.warehouseBeta.table.Staff;

public interface StaffService {

	//��ȡ����Ա������Ϣ
	List<Staff> getAllStaffInformation();
	
	//�鿴������˺��Ƿ���ȷ
	boolean checkStaffInformation(String name,String password);
	
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
