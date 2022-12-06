package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.beans.CurrencyExchange;
import com.microservices.currencyexchangeservice.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment env;


    @Autowired
    CurrencyRepository repository;

    @GetMapping("/currency-exchange/from/{from_currency}/to/{to_currency}")

    public CurrencyExchange retriveExchangeValue(@PathVariable("from_currency")
                                                         String from, @PathVariable("to_currency") String to) {

        String portValue=env.getProperty("server.port");

       CurrencyExchange currencyExchange= repository.findByFromAndTo(from,to);
       currencyExchange.setEnvironment(portValue);

    return currencyExchange;


    }
}
