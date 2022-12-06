package com.microservices.currencyexchangeservice.repository;

import com.microservices.currencyexchangeservice.beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyExchange,Integer> {

   CurrencyExchange findByFromAndTo(String from,String to);
}
