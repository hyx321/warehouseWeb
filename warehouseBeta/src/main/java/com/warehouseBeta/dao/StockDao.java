package com.warehouseBeta.dao;

import java.util.List;

import com.warehouseBeta.table.Commodity;
import com.warehouseBeta.table.Stock;


public interface StockDao {
	
	//获取所有仓库的信息
	List<Stock> getAllStockInformation();
	
	//更新仓库的信息
	void updateStockInformation(Stock stock);
	
	//删除仓库的信息
	void deleteStockInformation(int ID);
	
	//新增/插入仓库的信息
	void insertStockInformation(Stock stock);
	
	//获取商品信息
	List<Commodity> getCommodity(int ID);
	
	//获取商品信息
	List<Stock> getStockInformation(int ID);
	
	//获取ID 
	int getID();
	
	//新增商品信息
	void insertCommodity(Commodity commodity);
	
	//获取商品的数量
	int getCommodityCount(int id);
	
	//在更新了销售记录后，也随之更新商品数量
	void updateCommodityCount(int id,int count);
}
