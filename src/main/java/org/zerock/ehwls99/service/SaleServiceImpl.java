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
	
	@Override
	public void deleteSale(int productSaleId) {
		log.info("deleteSale for productSaleId: " + productSaleId);
		
		// product_sale에서 order_sale의 id 찾기
		List<Integer> orderSaleIds = mapper.findOrderSaleIdsByProductSaleId(productSaleId);
		
		for (Integer orderSaleId : orderSaleIds) {
			// order_sale의 수량 확인
			int quantity = mapper.findQuantityByOrderSaleId(orderSaleId);
			
			// product의 재고 수량 업데이트
			int productId = mapper.findProductIdByOrderSaleId(orderSaleId);
			mapper.updateProductQuantity(productId, quantity);
			
			// order_sale 삭제
			mapper.deleteOrderSaleById(orderSaleId);
		}
		
		// product_sale 삭제
		mapper.deleteProductSaleById(productSaleId);
	}
	
}
