package com.warehouseBeta.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouseBeta.service.StaffService;
import com.warehouseBeta.table.Staff;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/Staff")
public class StaffController {
	@Autowired
	private StaffService staffService;
	
	//��ȡ����Ա������Ϣ
	@RequestMapping(value="/StaffList",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<Staff> itemlist = staffService.getAllStaffInformation();
		JSONArray json = JSONArray.fromObject(itemlist);	
		model.addAttribute("itemlist",json);		
	
		return "StaffList";
	}
	
	//�����˺ŵ���Ϣ
	@RequestMapping(value="/CheckLogin",method=RequestMethod.GET)
	public void check(HttpServletResponse response,String name,String password)throws Exception{
		System.out.println("ִ�м������С�������");
		name= java.net.URLDecoder.decode(name, "UTF-8");
		boolean result = staffService.checkStaffInformation(name, password);
		System.out.println(result);
		if(result) {
			System.out.println("����ҳ��");
			response.sendRedirect("/warehouseBeta/Stock/StockList");
		}else {
			response.sendRedirect("/warehouseBeta/index.jsp");
		}
	}
	
	//����Ա������Ϣ
	@ResponseBody
	@RequestMapping(value="/UpdateStaff",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Staff staff){
		System.out.println("ִ�и��²����С�������");
		staffService.updateStaffInformation(staff);
	}
	
	//ɾ��Ա������Ϣ
	@RequestMapping(value="/DeleteStaff",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("ִ��ɾ�������С�������");
		staffService.deleteStaffInformation(Integer.parseInt(ID));
	}
	
	//����Ա����Ϣ
	@ResponseBody
	@RequestMapping(value="/AddStaff",method=RequestMethod.POST)
	public void add(HttpServletRequest request,HttpServletResponse response,Staff staff) {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("ִ�в��������������");	
		staffService.insertStaffInformation(staff);	
	}
	
	//��ȡԱ����Ϣ
	@RequestMapping(value="/GetStaff",method=RequestMethod.POST)
	public void getStaff(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("ִ�л�ȡ��Ʒ��Ϣ����....");
		JSONArray json = JSONArray.fromObject(staffService.getStaffInformation(ID));
		response.getWriter().print(json);
	}
	
}
