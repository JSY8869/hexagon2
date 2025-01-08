package org.zerock.ehwls99.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.ehwls99.mapper.SaleMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SaleServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private SaleService service;
	
	@Setter(onMethod_ = {@Autowired})
	private SaleMapper mapper;
	
	// @Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(sale -> log.info(sale));
	}
	
}
