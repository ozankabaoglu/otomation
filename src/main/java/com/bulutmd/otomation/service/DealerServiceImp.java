package com.bulutmd.otomation.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bulutmd.otomation.dao.DealerRepository;
import com.bulutmd.otomation.entity.Dealer;
import com.bulutmd.otomation.util.Utilities;

@Service
public class DealerServiceImp implements DealerService {

	@Autowired
	private DealerRepository dealerRepository;
	
	@Override
	public String checkDealer(Dealer dealer) {
		String tcNo = dealer.getTcNo();
		if(StringUtils.isBlank(tcNo)) {
			return "Tckn dolu olmalıdır.";
		}
		if(!NumberUtils.isDigits(tcNo)) {
			return "Tckn nümerik olmalıdır.";
		}
		if(!Utilities.verifyNumber(tcNo)) {
			return "Geçersiz tckn.";
		}
		
		String tel = dealer.getTel();
		if(StringUtils.isBlank(tel)) {
			return "Telefon dolu olmalıdır.";
		}
		if(!NumberUtils.isDigits(tel)) {
			return "Telefon nümerik olmalıdır.";
		}
		
		return null;
	}

	@Override
	public void saveDealer(Dealer dealer) {
		dealerRepository.save(dealer);
	}

}
