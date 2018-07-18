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

import com.warehouseBeta.service.CustomerService;
import com.warehouseBeta.table.Customer;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//获取所有客户的信息
	@RequestMapping(value="/CustomerList",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<Customer> itemlist = customerService.getAllCustomerInformation();
		JSONArray json = JSONArray.fromObject(itemlist);	
		model.addAttribute("itemlist",json);		
		return "CustomerList";
	}

	//更新客户的信息
	@ResponseBody
	@RequestMapping(value="/UpdateCustomer",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Customer customer){
		System.out.println("执行客户更新操作中。。。。");
		customerService.updateCustomerInformation(customer);
	}
	
	//删除客户的信息
	@RequestMapping(value="/DeleteCustomer",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("执行删除操作中。。。。");
		customerService.deleteCustomerInformation(Integer.parseInt(ID));
	}
	
	//新增客户信息
	@ResponseBody
	@RequestMapping(value="/AddCustomer",method=RequestMethod.POST)
	public void add(HttpServletRequest request,HttpServletResponse response,Customer customer) {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行插入操作。。。。");	
		customerService.insertCustomerInformation(customer);	
	}
	
	//获取客户信息
	@RequestMapping(value="/GetCustomer",method=RequestMethod.POST)
	public void getCustomer(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行获取商品信息操作....");
		JSONArray json = JSONArray.fromObject(customerService.getCustomerInformation(ID));
		response.getWriter().print(json);
	}
	
	//获取客户交易记录
	@RequestMapping(value="/GetSale",method=RequestMethod.POST)
	public void getSale(HttpServletResponse response,String purchaser) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行获取商品信息操作....");
		JSONArray json = JSONArray.fromObject(customerService.getSaleInformation(purchaser));
		response.getWriter().print(json);
	}
	
}
