package br.com.academy.ratkovski.Poc.Java.Kafka.Consumer.kafka;/*
 * @created 29/01/2022 - 18:34
 * @project Poc-Java-Kafka-Consumer
 * @author Ratkovski
 */

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostListener {
  @KafkaListener(topics = "test_topic", groupId = "groupTest",
  properties = {"spring.json.value.default.type=br.com.academy.ratkovski.Poc.Java.Kafka.Consumer.domain.User"})
  public void listener( ConsumerRecord<String, Object> consumerRecord) {
    System.out.println("___________________________________________________________");
    System.out.println("Message received in with offset: " + consumerRecord.offset());
    System.out.println("Topic: " + consumerRecord.topic());
    System.out.println("Partition: " + consumerRecord.partition());
    System.out.println("Object: " + consumerRecord.value() );
    System.out.println("___________________________________________________________");



  }
}
