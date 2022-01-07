package com.example.demo.designPattern.kafkaTest;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

@Configuration
public class ConsumerConfig {
  @Bean
  public ConsumerFactory<String, String> consumerFactory1() {
//    JsonDeserializer<String> deserializer = new JsonDeserializer<>(SiteInfoDto.class);
//    deserializer.setRemoveTypeHeaders(false);
////    deserializer.addTrustedPackages("kr.co.parkingcloud.site");
//    deserializer.setUseTypeMapperForKey(true);

    Map<String, Object> props = new HashMap<>();
    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092, localhost:9093, localhost:9094");
    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        StringDeserializer.class);
    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
//    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG,"CONSUMER-GROUP-ID-CONFIG-SET");
//    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "Instants_id-parkUnique");
//    // read_committed : transaction 이 committed 된 메시지만 읽겠다는 의미
//    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_uncommitted");
//    // broker 에서 consumer 를 트래킹 가능하게 해주는 id
//    props.put(org.apache.kafka.clients.consumer.ConsumerConfig.CLIENT_ID_CONFIG, "PARKINGLOT-CONSUME");

    return new DefaultKafkaConsumerFactory<>(props);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory1());
    ContainerProperties props = factory.getContainerProperties();
    props.setAckMode(AckMode.MANUAL_IMMEDIATE);
    return factory;
  }
}
