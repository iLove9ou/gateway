package com.bank.credit.gateway.controller;

import com.bank.credit.gateway.business.BankCreditBusiness;
import com.bank.credit.gateway.format.*;
import com.bank.credit.gateway.manager.BankCreditBusinessManager;
import com.bank.credit.gateway.mq.Producer;
import com.bank.credit.gateway.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;


@RestController
public class Home {

    @Autowired
    private BankCreditBusinessManager bankCreditBusinessManager;

    @PostMapping(value = "/credit_apply", consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Document creditApply(@RequestBody User user00) {
        System.out.println(user00.getId() + ":" + user00.getName());
        return bankCreditBusinessManager.getDocument();
    }

    @PostMapping(value = "/sendMsg")
    public Document sendMsg() {
        Producer producer = new Producer();
        producer.send();

        return new Document();
    }
}
