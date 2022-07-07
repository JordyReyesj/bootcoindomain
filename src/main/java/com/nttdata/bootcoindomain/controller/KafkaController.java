package com.nttdata.bootcoindomain.controller;

import com.nttdata.bootcoindomain.producer.KafkaChangeRateProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final KafkaChangeRateProducer kafkaChangeRateProducer;

  @Autowired
  KafkaController(KafkaChangeRateProducer kafkaStringProducer) {
    this.kafkaChangeRateProducer = kafkaStringProducer;
  }

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    this.kafkaChangeRateProducer.sendMessage(message);
  }
}
