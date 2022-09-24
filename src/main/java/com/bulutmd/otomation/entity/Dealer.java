package com.bulutmd.otomation.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String tcNo;
	private String address;
	private String tel;
	private String email;
	@DateTimeFormat(iso=ISO.DATE)
	private Date birthDate;
	private boolean retailTrade;
	private String lokumReason;
	private String lokumRegion;
	private BigDecimal amount;
	private String addInfo;
}
