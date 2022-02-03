package br.com.academy.ratkovski.Poc.Java.Kafka.Consumer.config;/*
 * @created 29/01/2022 - 18:23
 * @project Poc-Java-Kafka-Consumer
 * @author Ratkovski
 */

import br.com.academy.ratkovski.Poc.Java.Kafka.Consumer.domain.Post;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConfiguration {

    @Value("${KAFKA_BOOTSTRAP_SERVER:127.0.0.1:9092}")
    private String bootStrapServer;

    @Value("${SCHEMA_REGISTRY_URL:127.0.0.1:8081}")
    private String schemaRegistryUrl;


  //Consumer properties
  public ConsumerFactory<String, kafka.avro.Post> consumerFactory() {
      Map<String, Object> config = new HashMap<>();
      config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
      config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "1");
      config.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
      //config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"");//pode possuir 3 valores *earliest/latest/none
      return new DefaultKafkaConsumerFactory<>(config);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, kafka.avro.Post> kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, kafka.avro.Post> factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
    }
  }
