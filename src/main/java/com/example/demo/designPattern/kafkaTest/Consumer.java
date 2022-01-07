package com.example.demo.designPattern.kafkaTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {
  @KafkaListener(
      containerFactory = "kafkaListenerContainerFactory",
      topicPartitions = @TopicPartition(topic = "parttest"
//          , partitions = ""
//      ,partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "0")
      ))
  public void listenAndSend(@Headers MessageHeaders headers, @Payload String message,
      Acknowledgment acknowledgment) {
    log.info("Headers :\r\n {}", headers.toString());

//    log.info("Consumed Message\r\n : {}", message.getSiteId());
//    log.info("Consumed Message\r\n : {}", message.getName());
//    log.info("Consumed Message\r\n : {}", message.getUid());
//    log.info("Consumed Message\r\n : {}", message.toString());
//    SiteInfo siteInfo = message.toEntitySiteInfo(message);
//    repository.save(siteInfo);
//    acknowledgment.acknowledge();
  }
}
