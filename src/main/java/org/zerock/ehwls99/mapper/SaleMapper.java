package org.zerock.ehwls99.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zerock.ehwls99.domain.SaleVO;

@Mapper
public interface SaleMapper {

	public List<SaleVO> getList();
	
	public List<Integer> findOrderSaleIdsByProductSaleId(int productSaleId);
	
	public int findQuantityByOrderSaleId(int orderSaleId);
	
	public int findProductIdByOrderSaleId(int orderSaleId);
	
	public void updateProductQuantity(@Param("productId") int productId, @Param("quantity") int quantity);
	
	public void deleteOrderSaleById(int orderSaleId);
	
	public void deleteProductSaleById(int productSaleId);
}
