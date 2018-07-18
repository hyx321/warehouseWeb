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
	
	//获取所有员工的信息
	@RequestMapping(value="/StaffList",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<Staff> itemlist = staffService.getAllStaffInformation();
		JSONArray json = JSONArray.fromObject(itemlist);	
		model.addAttribute("itemlist",json);		
	
		return "StaffList";
	}
	
	//检验账号的信息
	@RequestMapping(value="/CheckLogin",method=RequestMethod.GET)
	public void check(HttpServletResponse response,String name,String password)throws Exception{
		System.out.println("执行检查操作中。。。。");
		name= java.net.URLDecoder.decode(name, "UTF-8");
		boolean result = staffService.checkStaffInformation(name, password);
		System.out.println(result);
		if(result) {
			System.out.println("进入页面");
			response.sendRedirect("/warehouseBeta/Stock/StockList");
		}else {
			response.sendRedirect("/warehouseBeta/index.jsp");
		}
	}
	
	//更新员工的信息
	@ResponseBody
	@RequestMapping(value="/UpdateStaff",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Staff staff){
		System.out.println("执行更新操作中。。。。");
		staffService.updateStaffInformation(staff);
	}
	
	//删除员工的信息
	@RequestMapping(value="/DeleteStaff",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("执行删除操作中。。。。");
		staffService.deleteStaffInformation(Integer.parseInt(ID));
	}
	
	//新增员工信息
	@ResponseBody
	@RequestMapping(value="/AddStaff",method=RequestMethod.POST)
	public void add(HttpServletRequest request,HttpServletResponse response,Staff staff) {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行插入操作。。。。");	
		staffService.insertStaffInformation(staff);	
	}
	
	//获取员工信息
	@RequestMapping(value="/GetStaff",method=RequestMethod.POST)
	public void getStaff(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行获取商品信息操作....");
		JSONArray json = JSONArray.fromObject(staffService.getStaffInformation(ID));
		response.getWriter().print(json);
	}
	
}
