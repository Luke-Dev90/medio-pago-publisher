package com.lchalela.publisher.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lchalela.publisher.dto.TransactionDTO;


@Service
public class PublisherServiceImpl implements PublisherService{
	
	private Logger logger = LoggerFactory.getLogger(PublisherServiceImpl.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Override
	public String sendMessage(TransactionDTO transactionDTO) {
		
		jmsTemplate.send("transaction", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				logger.info("Init creation message");
				
				ObjectMapper mapper = new ObjectMapper();
				
				mapper.registerModule(new JavaTimeModule());
				
				String objStr;
				ObjectMessage object = null;
				
				try {
					objStr = mapper.writeValueAsString(transactionDTO);
					object  = session.createObjectMessage( objStr);
				} catch (JsonProcessingException e) {
					logger.error(e.getMessage());
				}
				return object;
			}
			
		});
		logger.info("return message");
		return transactionDTO.toString();
	}

}
