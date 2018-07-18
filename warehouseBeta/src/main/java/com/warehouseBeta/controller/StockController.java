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
import com.warehouseBeta.service.StockService;
import com.warehouseBeta.service.TransactionService;
import com.warehouseBeta.table.Commodity;
import com.warehouseBeta.table.Stock;
import com.warehouseBeta.table.Transaction;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/Stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private StaffService staffService;
	
	//��ȡ�ֿ����Ϣ
	@RequestMapping(value="/StockList",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<Stock> itemlist = stockService.getAllStockInformation();
		JSONArray json = JSONArray.fromObject(itemlist);	
		model.addAttribute("itemlist",json);	
		
		JSONArray StaffName = JSONArray.fromObject(staffService.getAllStaffName());
		model.addAttribute("StaffName",StaffName);	
		
		return "StockList";
	}
	
	//���²ֿ����Ϣ
	@ResponseBody
	@RequestMapping(value="/UpdateStock",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Stock stock){
		System.out.println("ִ�и��²����С�������");
		System.out.println(stock);
		stockService.updateStockInformation(stock);
	}
	
	//ɾ���ֿ����Ϣ
	@RequestMapping(value="/DeleteStock",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("ִ��ɾ�������С�������");
		stockService.deleteStockInformation(Integer.parseInt(ID));
	}
	
	/*
	 * 1.�����ֿ���Ϣ
	 * 2.����������Ϣ��������Ϣ��ֻ��ID�������������ݣ�������Ϊ�գ�
	 */
	@ResponseBody
	@RequestMapping(value="/AddStock",method=RequestMethod.POST)
	public void add(HttpServletResponse response,Stock stock) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("ִ�в��������������");	
		stockService.insertStockInformation(stock);
		response.getWriter().print(stockService.getID()+"");
	}
	
	//��ȡ��Ʒ��Ϣ
	@RequestMapping(value="/GetCommodity",method=RequestMethod.POST)
	public void getCommodity(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("ִ�л�ȡ��Ʒ��Ϣ����....");
		JSONArray json = JSONArray.fromObject(stockService.getCommodity(ID));
		response.getWriter().print(json);
	}
	
	//��ȡ�ֿ���Ϣ
	
	@RequestMapping(value="/GetStock",method=RequestMethod.POST)
	public void getStock(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("ִ�л�ȡ�ֿ���Ϣ����....");
		JSONArray json = JSONArray.fromObject(stockService.getStockInformation(ID));
		response.getWriter().print(json);
	}	
	
	//������Ʒ��Ϣ
	@ResponseBody
	@RequestMapping(value="/AddCommodity",method=RequestMethod.POST)
	public void addCommodity(HttpServletResponse response,Commodity commodity) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("ִ�в�����Ʒ��Ϣ������������");	
		stockService.insertCommodity(commodity);
	}
	

}
