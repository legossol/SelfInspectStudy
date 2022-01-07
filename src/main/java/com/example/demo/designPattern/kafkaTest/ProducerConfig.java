package com.example.demo.designPattern.kafkaTest;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
@Configuration
public class ProducerConfig {
  @Bean(value = "myProducerFactory")
  public ProducerFactory<String, String> myProducerFactory(){
    Map<String, String> props = new HashMap<>();
    props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092, localhost:9093, localhost:9094");
    props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
    props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
//    props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,
//        UniformStickyPartitioner.class.getName());
//    props.put(ProducerConfig.ACKS_CONFIG, "all");
//    props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
//    props.put(ProducerConfig.RETRIES_CONFIG, "5");
//    // 트랜잭션 처리를 한다고 명시적으로 설정
//    props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
//    // 프로듀서 트랜잭션을 구분하기 위한 ID
//    props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "FROMBUSINESSCOMPANY");
//    // 프로듀서가 close 하지 않고 어플리케이션이 종료되면 TRANSACTION_TIMEOUT_CONFIG 에 설정된 시간 이후에 abort 처리됨
//    props.put(ProducerConfig.TRANSACTION_TIMEOUT_CONFIG, 60000);
//    // broker 에서 producer 를 트래킹 가능하게 해주는 id
//    props.put(ProducerConfig.CLIENT_ID_CONFIG, "BUSINESSCOMPANY-PRODUCER");
    DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory(props);
    factory.transactionCapable();
    factory.setTransactionIdPrefix("factory-Trans");
    return factory;
  }

  @Bean(value = "configedTemplate")
  public KafkaTemplate<String, String> configedTemplate(){
    return new KafkaTemplate<String,String>(myProducerFactory());
  }
}
