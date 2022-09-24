package com.bulutmd.otomation.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bulutmd.otomation.entity.Dealer;
import com.bulutmd.otomation.service.DealerService;

@Controller
public class HomeController {

	@Autowired
	private DealerService dealerService;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute(new Dealer());
		return "register";
	}

	@PostMapping("/saveDealer")
	public String saveDealer(@ModelAttribute("dealer") Dealer dealer, Model model) {
		String erroMsg = dealerService.checkDealer(dealer);
		if(StringUtils.isNotBlank(erroMsg)) {
			model.addAttribute("erroMsg", erroMsg);
			return "register";
		}
		dealerService.saveDealer(dealer);
		return "register_success";
	}

}