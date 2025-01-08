package org.zerock.ehwls99.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {

	// 품목PK
	private int id;
	
	// 창고FK
	private int warehouse;
	
	// 품목명
	private String name;
	
	// 규격
	private String standard;
	
	// 재고 수량
	private int quantity;
	
	// 단가
	private int price;
	
	// 공급가액
	private String supplyPrice;
	
	// 생성일
	private Date createdAt;
	
	// 수정일
	private Date updatedAt;
	
}
