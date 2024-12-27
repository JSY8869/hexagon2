package org.zerock.ehwls99.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.ehwls99.domain.SaleVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SaleMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private SaleMapper mapper;
	
	@Test
	public void testGetList() {
		List<SaleVO> saleList = mapper.getList();
		saleList.forEach(sale -> log.info(sale));
	}
	
}
