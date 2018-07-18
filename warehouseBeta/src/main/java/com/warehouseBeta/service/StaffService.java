package com.warehouseBeta.service;

import java.util.List;

import com.warehouseBeta.table.Staff;

public interface StaffService {

	//获取所有员工的信息
	List<Staff> getAllStaffInformation();
	
	//查看登入的账号是否正确
	boolean checkStaffInformation(String name,String password);
	
	//更新员工的信息
	void updateStaffInformation(Staff staff);
	
	//删除员工的信息
	void deleteStaffInformation(int ID);
	
	//新增/插入员工的信息
	void insertStaffInformation(Staff staff);
	
	//获取员工信息
	List<Staff> getStaffInformation(int ID);
	
	//获取所有员工的名字
	List<Staff> getAllStaffName();
}
