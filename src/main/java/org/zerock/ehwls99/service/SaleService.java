package org.zerock.ehwls99.service;

import java.util.List;

import org.zerock.ehwls99.domain.SaleVO;

public interface SaleService {

	public List<SaleVO> getList();
	
	public void deleteSale(int productSaleId);
	
}
