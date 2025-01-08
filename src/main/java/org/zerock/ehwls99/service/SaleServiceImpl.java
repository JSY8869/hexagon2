package org.zerock.ehwls99.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.ehwls99.domain.SaleVO;
import org.zerock.ehwls99.mapper.SaleMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

	private SaleMapper mapper;

	@Override
	public List<SaleVO> getList() {
		log.info("getList.............");
		return mapper.getList();
	}
	
}
