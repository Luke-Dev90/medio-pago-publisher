package com.lchalela.publisher.service;

import com.lchalela.publisher.dto.TransactionDTO;

public interface PublisherService {

	public String sendMessage(TransactionDTO transactionDTO);
}
