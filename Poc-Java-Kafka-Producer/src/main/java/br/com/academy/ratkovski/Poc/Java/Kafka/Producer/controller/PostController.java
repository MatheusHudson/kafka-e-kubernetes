package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.controller;

import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.domain.Post;
import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.kafka.KafkaProducerService;
import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.service.PostService;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Properties;

@RestController
@RequestMapping("/posts/")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final KafkaProducerService producer;

    @GetMapping("{userId}")
    private ResponseEntity<Post> post(@PathVariable String userId) {

        try {
            Post post = postService.consulta(userId);
            producer.getProducerRecord().send(new ProducerRecord<>("test_topic", userId, post));
            LoggerFactory.getLogger(PostController.class).info("Gerado com sucesso!");
            System.out.println("Record enviado!");
            return ResponseEntity.ok().body(post);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }




}
