package com.warehouseBeta.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouseBeta.dao.TransactionDao;
import com.warehouseBeta.service.TransactionService;
import com.warehouseBeta.table.Transaction;

@Service
public class TransactionServiceImp implements TransactionService{
	
	@Autowired
	private TransactionDao transactionDao;
	@Override
	public List<Transaction> getAllTransactionInformation() {
		
		return transactionDao.getAllTransactionInformation();
	}

	@Override
	public void updateTransactionInformation(Transaction transaction) {
		
		transactionDao.updateTransactionInformation(transaction);
	}

	@Override
	public void deleteTransactionInformation(int ID) {
		
		transactionDao.deleteTransactionInformation(ID);
	}

	@Override
	public void insertTransactionInformation(Transaction transaction) {
		
		transactionDao.insertTransactionInformation(transaction);
	}

	@Override
	public List<Transaction> getTransactionInformation(int ID) {
		
		return transactionDao.getTransactionInformation(ID);
	}

	@Override
	public void insertTransactionTwo(int ID, String name, String operator) {
		
		transactionDao.insertTransactionTwo(ID, name, operator);
	}

}
