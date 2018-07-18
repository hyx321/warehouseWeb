package com.warehouseBeta.service;

import java.util.List;

import com.warehouseBeta.table.Transaction;


public interface TransactionService {
		//获取所有交易记录的信息
		List<Transaction> getAllTransactionInformation();
		
		//更新交易记录的信息
		void updateTransactionInformation(Transaction transaction);
		
		//删除交易记录的信息
		void deleteTransactionInformation(int ID);
		
		//新增/插入交易记录的信息
		void insertTransactionInformation(Transaction transaction);
		
		//获取交易记录信息
		List<Transaction> getTransactionInformation(int ID);
		
		//插入交易记录的信息（只有ID和姓名,其他的字段都显示未交易）
		void insertTransactionTwo(int ID,String name,String operator);
		
	
}
