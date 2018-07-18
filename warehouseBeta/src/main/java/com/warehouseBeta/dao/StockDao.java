package com.warehouseBeta.dao;

import java.util.List;

import com.warehouseBeta.table.Commodity;
import com.warehouseBeta.table.Stock;


public interface StockDao {
	
	//��ȡ���вֿ����Ϣ
	List<Stock> getAllStockInformation();
	
	//���²ֿ����Ϣ
	void updateStockInformation(Stock stock);
	
	//ɾ���ֿ����Ϣ
	void deleteStockInformation(int ID);
	
	//����/����ֿ����Ϣ
	void insertStockInformation(Stock stock);
	
	//��ȡ��Ʒ��Ϣ
	List<Commodity> getCommodity(int ID);
	
	//��ȡ��Ʒ��Ϣ
	List<Stock> getStockInformation(int ID);
	
	//��ȡID 
	int getID();
	
	//������Ʒ��Ϣ
	void insertCommodity(Commodity commodity);
	
	//��ȡ��Ʒ������
	int getCommodityCount(int id);
	
	//�ڸ��������ۼ�¼��Ҳ��֮������Ʒ����
	void updateCommodityCount(int id,int count);
}
