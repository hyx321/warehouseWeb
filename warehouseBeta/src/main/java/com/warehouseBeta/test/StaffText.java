package com.warehouseBeta.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.warehouseBeta.service.StaffService;
import com.warehouseBeta.service.StockService;
import com.warehouseBeta.table.Staff;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Spring/springmvc-dao.xml",
						"classpath:Spring/springmvc-service.xml"})
public class StaffText {

@Autowired
private StaffService staffService;
@Autowired
private StockService stockService;
/**
 * @throws Exception
 */
@Test
public void testGetAllInformation() throws Exception{
	
	System.out.println(stockService.getID()+"");
	
}
}
