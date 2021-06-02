package io.betterbanking.repository;

import io.betterbanking.entity.Transaction;

import java.util.List;

public interface TransactionApiClient {
    List<Transaction> findAllByAccountNumber(final Integer accountNumber) throws Exception;
}
