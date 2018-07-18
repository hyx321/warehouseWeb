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
	
	//获取交易记录的信息
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
	
	//更新交易记录的信息
	@ResponseBody
	@RequestMapping(value="/UpdateTransaction",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Transaction transaction) throws IOException{
		System.out.println("执行更新操作中。。。。");
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
			response.getWriter().print("数量不够，需要进货了");
		}
	}
	
	//删除交易记录的信息
	@RequestMapping(value="/DeleteTransaction",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("执行删除操作中。。。。");
		transactionService.deleteTransactionInformation(Integer.parseInt(ID));
	}
	
	//获取交易记录信息
	@RequestMapping(value="/GetTransaction",method=RequestMethod.POST)
	public void getTransaction(HttpServletResponse response,int ID) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("执行获取商品信息操作....");
			JSONArray json = JSONArray.fromObject(transactionService.getTransactionInformation(ID));
			response.getWriter().print(json);
	}
	
	//新增交易信息
	@RequestMapping(value="/addTransaction",method=RequestMethod.POST)
	public void addTransaction(HttpServletResponse response,Transaction transaction) {
		System.out.println("执行交易记录插入的操作");
		transactionService.insertTransactionInformation(transaction);
	}
	
	
}
