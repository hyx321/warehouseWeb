package com.warehouseBeta.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouseBeta.dao.StockDao;
import com.warehouseBeta.service.StockService;
import com.warehouseBeta.table.Commodity;
import com.warehouseBeta.table.Stock;

@Service
public class StockServiceImp implements StockService{

	@Autowired
	private StockDao stockDao;
	
	//获取仓库信息
	@Override
	public List<Stock> getAllStockInformation() {
	
		return stockDao.getAllStockInformation();
	}

	//更新仓库
	@ResponseBody
	@Override
	public void updateStockInformation(Stock stock) {
		
		stockDao.updateStockInformation(stock);	
	}

	//删除仓库信息
	@Override
	public void deleteStockInformation(int ID) {
		
		stockDao.deleteStockInformation(ID);
	}

	//新增仓库信息
	@ResponseBody
	@Override
	public void insertStockInformation(Stock stock) {
		
		stockDao.insertStockInformation(stock);
	}

	@Override
	public List<Commodity> getCommodity(int ID) {
		
		return stockDao.getCommodity(ID);
	}

	@Override
	public List<Stock> getStockInformation(int ID) {
		
		return stockDao.getStockInformation(ID);
	}

	@Override
	public int getID() {
		return stockDao.getID();
	}

	@Override
	public void insertCommodity(Commodity commodity) {
		
		stockDao.insertCommodity(commodity);
	}

	@Override
	public int getCommodityCount(int id) {
		
		return stockDao.getCommodityCount(id);
	}

	@Override
	public void updateCommodityCount(int id,int count) {
		
		stockDao.updateCommodityCount(id,count);
	}
	
	
}
