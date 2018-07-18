package com.warehouseBeta.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouseBeta.dao.StaffDao;
import com.warehouseBeta.service.StaffService;
import com.warehouseBeta.table.Staff;

@Service
public class StaffServiceImp implements StaffService{
	
	@Autowired
	private StaffDao staffDao;
	
	//获取所有员工的信息
	@Override
	public List<Staff> getAllStaffInformation() {
		
		return staffDao.getAllStaffInformation();
	}
	
	//检验登入账户是否正确
	@Override
	public boolean checkStaffInformation(String name,String password) {
		
		if(password.equals(staffDao.checkStaffInformation(name))){
			return true;
		}
		else 
			return false;
	}
	
	//更新员工信息
	@Override
	public void updateStaffInformation(Staff staff) {
		
		staffDao.updateStaffInformation(staff);	
	}
	
	//删除员工信息
	@Override
	public void deleteStaffInformation(int ID) {
		
		staffDao.deleteStaffInformation(ID);	
	}

	//插入员工信息
	@Override
	public void insertStaffInformation(Staff staff) {
		
		 staffDao.insertStaffInformation(staff);
	}

	@Override
	public List<Staff> getStaffInformation(int ID) {
		
		return staffDao.getStaffInformation(ID);
	}

	@Override
	public List<Staff> getAllStaffName() {
		
		return staffDao.getAllStaffName();
	}

}
