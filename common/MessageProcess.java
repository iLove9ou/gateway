package com.bank.credit.gateway.common;

public interface MessageProcess<T> {

    DetailRes process(T message);
}
