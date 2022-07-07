package com.nttdata.bootcoindomain.producer;

import com.nttdata.bootcoindomain.consumer.KafkaChangeRateConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * KafkaChangeRateProducer.
 */
@Component
public class KafkaChangeRateProducer {
  private static final Logger LOGGER= LoggerFactory.getLogger(KafkaChangeRateConsumer.class);

  private final KafkaTemplate<String, String> kafkaTemplate;

  /**
   * KafkaChangeRateProducer.
   */
  public KafkaChangeRateProducer(@Qualifier("KafkaProducerTemplate") KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate= kafkaTemplate;
  }

  /**
   * sendMessage.
   */
  public void sendMessage(String message){
    LOGGER.info("Producing message {}",message);
    this.kafkaTemplate.send("TOPIC-DEMO",message);
  }
}
