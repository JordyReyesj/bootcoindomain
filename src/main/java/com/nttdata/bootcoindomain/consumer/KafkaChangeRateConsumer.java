package com.nttdata.bootcoindomain.consumer;


import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;
/**
 * KafkaChangeRateConsumer.
 */
@Component
public class KafkaChangeRateConsumer {
  /**
   * Kafka logger.
   */
  Logger logger = (Logger) LoggerFactory.getLogger(KafkaChangeRateConsumer.class);

  /**
   * kafkaListener.
   */
  @KafkaListener(topics="TOPIC-DEMO", groupId = "group_id")
  public void consumer(String message){
    logger.info("Consuming Message {}"+ message);

  }

}
