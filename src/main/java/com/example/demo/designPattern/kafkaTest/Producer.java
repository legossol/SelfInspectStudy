package com.example.demo.designPattern.kafkaTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {
//
//
//
//  public static void main(String[] args) {
//    KafkaTemplate<String,String>  kafkaTemplate;
//
//
//    String message="";
//
//    while(message == "exit"){
//      Scanner scanner = new Scanner(System.in);
//      message = scanner.next();
//    }
//    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("parttest",1,"hihi",message);
//    future.addCallback(new ListenableFutureCallback<>() {
//      @Override
//      public void onSuccess(SendResult<String, String> result) {
//        log.info("Sent message=[" + result.getProducerRecord().value().toString() +
//            "] with offset=[" + result.getRecordMetadata().offset() + "]");
//      }
//      @Override
//      public void onFailure(Throwable ex) {
//        log.error("Unable to send message=[] due to : " + ex.getMessage());
//      }
//    });
//  }
}
