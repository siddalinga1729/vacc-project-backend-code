package com.citizen_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.citizen_service.dto.CitizenDto;

@Service
public class CitizenProducer {

	private static final String TOPIC = "vc";

	@Autowired
	private KafkaTemplate<String, CitizenDto> kafkaTemplate;

	public void save(CitizenDto citizenDto) {
		Message<CitizenDto> message = MessageBuilder.withPayload(citizenDto).setHeader(KafkaHeaders.TOPIC, TOPIC)
				.build();
		kafkaTemplate.send(message);
		// logger.info(String.format("Data produced ---> %S"),citizenDto.toString());
		System.out.println("-------------------------" + citizenDto.toString() + "----------------------------");
	}

}
