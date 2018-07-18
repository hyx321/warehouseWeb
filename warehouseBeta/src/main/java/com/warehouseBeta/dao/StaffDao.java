package com.warehouseBeta.dao;

import java.util.List;

import com.warehouseBeta.table.Customer;
import com.warehouseBeta.table.Staff;


public interface StaffDao {
	
	//获取所有员工的信息
	List<Staff> getAllStaffInformation();
	
	//查看登入的账号是否正确
	String checkStaffInformation(String name);
	
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
