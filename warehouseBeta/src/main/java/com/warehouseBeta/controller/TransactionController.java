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
import com.warehouseBeta.service.StaffService;
import com.warehouseBeta.service.StockService;
import com.warehouseBeta.service.TransactionService;
import com.warehouseBeta.table.Stock;
import com.warehouseBeta.table.Transaction;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/Transaction")
public class TransactionController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private StockService stockService;
	
	//��ȡ���׼�¼����Ϣ
	@RequestMapping(value="/TransactionList",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<Transaction> itemlist = transactionService.getAllTransactionInformation();
		JSONArray json = JSONArray.fromObject(itemlist);	
		model.addAttribute("itemlist",json);	
		
		JSONArray CustomerName = JSONArray.fromObject(customerService.getAllCustomerName());
		model.addAttribute("CustomerName",CustomerName);
		
		JSONArray StaffName = JSONArray.fromObject(staffService.getAllStaffName());
		model.addAttribute("StaffName",StaffName);	
		return "TransactionList";
	}
	
	//���½��׼�¼����Ϣ
	@ResponseBody
	@RequestMapping(value="/UpdateTransaction",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Transaction transaction) throws IOException{
		System.out.println("ִ�и��²����С�������");
		response.setContentType("text/html;charset=UTF-8");
		int commodityCount =stockService.getCommodityCount(transaction.getId());
		if(commodityCount>transaction.getCount()) {
			int count = commodityCount - transaction.getCount();
			transactionService.updateTransactionInformation(transaction);
			response.getWriter().print(count+"");
			List<Stock> stock =  stockService.getStockInformation(transaction.getId());
			stock.get(0).setCount(count);
			stock.get(0).setId(transaction.getId());
			stockService.updateStockInformation(stock.get(0));
		}
		else {
			response.getWriter().print("������������Ҫ������");
		}
	}
	
	//ɾ�����׼�¼����Ϣ
	@RequestMapping(value="/DeleteTransaction",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("ִ��ɾ�������С�������");
		transactionService.deleteTransactionInformation(Integer.parseInt(ID));
	}
	
	//��ȡ���׼�¼��Ϣ
	@RequestMapping(value="/GetTransaction",method=RequestMethod.POST)
	public void getTransaction(HttpServletResponse response,int ID) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("ִ�л�ȡ��Ʒ��Ϣ����....");
			JSONArray json = JSONArray.fromObject(transactionService.getTransactionInformation(ID));
			response.getWriter().print(json);
	}
	
	//����������Ϣ
	@RequestMapping(value="/addTransaction",method=RequestMethod.POST)
	public void addTransaction(HttpServletResponse response,Transaction transaction) {
		System.out.println("ִ�н��׼�¼����Ĳ���");
		transactionService.insertTransactionInformation(transaction);
	}
	
	
}
