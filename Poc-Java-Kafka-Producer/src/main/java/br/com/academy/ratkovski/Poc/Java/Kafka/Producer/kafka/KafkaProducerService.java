package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.kafka;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class KafkaProducerService {

    private final String bootStrapServer;

    private final String schemaRegistryUrl;

    private final KafkaProducer producerRecord;


    public KafkaProducerService(@Value("${server.kafka.bootstrap}")
                                        String bootStrapServer, @Value("${server.schema.bootstrap}")
                                        String schemaRegistryUrl) {
        this.bootStrapServer = bootStrapServer;
        this.schemaRegistryUrl = schemaRegistryUrl;
        this.producerRecord = criarProducer();
    }

    public KafkaProducer getProducerRecord() {
        return producerRecord;
    }

    private KafkaProducer criarProducer() {

        Properties properties = new Properties();

        //create Producer Properties
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        //create save Producer
        properties.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        properties.put(ProducerConfig.RETRIES_CONFIG, "10");
        properties.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);


        return new KafkaProducer(properties);
    }

}
