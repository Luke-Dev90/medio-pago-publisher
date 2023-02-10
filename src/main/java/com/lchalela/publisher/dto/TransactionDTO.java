package com.lchalela.publisher.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDTO {

	private String accountOrigin;
	private String aliasDestination;
	private String cbuDestination;
	private Boolean isProgrammed;
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm:ss")
	private LocalDateTime dateAcreditation;
	private String reason;
	private BigDecimal amount;
	
}
