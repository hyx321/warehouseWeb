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
	
	//获取仓库的信息
	@RequestMapping(value="/StockList",method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<Stock> itemlist = stockService.getAllStockInformation();
		JSONArray json = JSONArray.fromObject(itemlist);	
		model.addAttribute("itemlist",json);	
		
		JSONArray StaffName = JSONArray.fromObject(staffService.getAllStaffName());
		model.addAttribute("StaffName",StaffName);	
		
		return "StockList";
	}
	
	//更新仓库的信息
	@ResponseBody
	@RequestMapping(value="/UpdateStock",method=RequestMethod.POST)
	public void update(HttpServletResponse response, Stock stock){
		System.out.println("执行更新操作中。。。。");
		System.out.println(stock);
		stockService.updateStockInformation(stock);
	}
	
	//删除仓库的信息
	@RequestMapping(value="/DeleteStock",method=RequestMethod.POST)
	public void delete(HttpServletResponse response,String ID)throws Exception{
		System.out.println("执行删除操作中。。。。");
		stockService.deleteStockInformation(Integer.parseInt(ID));
	}
	
	/*
	 * 1.新增仓库信息
	 * 2.新增销售信息（销售信息中只有ID和名称两个数据，其他都为空）
	 */
	@ResponseBody
	@RequestMapping(value="/AddStock",method=RequestMethod.POST)
	public void add(HttpServletResponse response,Stock stock) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行插入操作。。。。");	
		stockService.insertStockInformation(stock);
		response.getWriter().print(stockService.getID()+"");
	}
	
	//获取商品信息
	@RequestMapping(value="/GetCommodity",method=RequestMethod.POST)
	public void getCommodity(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行获取商品信息操作....");
		JSONArray json = JSONArray.fromObject(stockService.getCommodity(ID));
		response.getWriter().print(json);
	}
	
	//获取仓库信息
	
	@RequestMapping(value="/GetStock",method=RequestMethod.POST)
	public void getStock(HttpServletResponse response,int ID) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行获取仓库信息操作....");
		JSONArray json = JSONArray.fromObject(stockService.getStockInformation(ID));
		response.getWriter().print(json);
	}	
	
	//新增商品信息
	@ResponseBody
	@RequestMapping(value="/AddCommodity",method=RequestMethod.POST)
	public void addCommodity(HttpServletResponse response,Commodity commodity) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("执行插入商品信息操作。。。。");	
		stockService.insertCommodity(commodity);
	}
	

}
