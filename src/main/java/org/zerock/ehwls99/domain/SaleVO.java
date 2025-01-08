package org.zerock.ehwls99.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SaleVO {
	
	// 생성일, 거래처명, 품목명, 금액합계, 거래유형명, 출하창고명
	
	// 생성일 product Table의 created_at
	private Date createdAt;
	
	// 거래처명 client Table의 trade_name
	private String tradeName;
	
	// 품목명 product Table의 name
	private String productName;
	
	// 금액합계 product Table (quantity * price = supply_price) + supply_price * 10%
	private Long priceSum;
	
	// 거래유형명 product_sale Table의 type
	private String type;
	
	// 출하창고명 shipment_warehouse Table의 name
	private String warehouseName;
	
}
