package org.zerock.ehwls99.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.ehwls99.service.SaleService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sale/*")
@AllArgsConstructor
public class SaleController {

	private SaleService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteSale(@RequestBody Map<String, Integer> request) {
		int productSaleId = request.get("productSaleId");
		
		try {
			service.deleteSale(productSaleId);
			return ResponseEntity.ok("삭제 완료");
		} catch (Exception e) {
			log.error("삭제 중 오류 발생", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 오류 발생");
		}
	}
	
}
