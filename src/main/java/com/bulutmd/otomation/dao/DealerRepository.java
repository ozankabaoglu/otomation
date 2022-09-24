package com.bulutmd.otomation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bulutmd.otomation.entity.Dealer;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
}