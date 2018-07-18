package com.warehouseBeta.service;

import java.util.List;

import com.warehouseBeta.table.Transaction;


public interface TransactionService {
		//��ȡ���н��׼�¼����Ϣ
		List<Transaction> getAllTransactionInformation();
		
		//���½��׼�¼����Ϣ
		void updateTransactionInformation(Transaction transaction);
		
		//ɾ�����׼�¼����Ϣ
		void deleteTransactionInformation(int ID);
		
		//����/���뽻�׼�¼����Ϣ
		void insertTransactionInformation(Transaction transaction);
		
		//��ȡ���׼�¼��Ϣ
		List<Transaction> getTransactionInformation(int ID);
		
		//���뽻�׼�¼����Ϣ��ֻ��ID������,�������ֶζ���ʾδ���ף�
		void insertTransactionTwo(int ID,String name,String operator);
		
	
}
