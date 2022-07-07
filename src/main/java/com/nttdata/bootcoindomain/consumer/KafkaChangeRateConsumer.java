package com.nttdata.bootcoindomain.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * KafkaChangeRateConsumer.
 */
@Component
public class KafkaChangeRateConsumer {
  /**
   * Kafka logger.
   */
  Logger logger = LoggerFactory.getLogger(KafkaChangeRateConsumer.class);

  /**
   * kafkaListener.
   */
  @KafkaListener(topics="TOPIC-DEMO", groupId = "group_id")
  public void consumer(String message){
    logger.info("Consuming Message {}"+ message);

  }

}
