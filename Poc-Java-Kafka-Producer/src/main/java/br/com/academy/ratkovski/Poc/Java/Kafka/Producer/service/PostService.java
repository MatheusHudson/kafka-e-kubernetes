package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.service;/*
 * @created 29/01/2022 - 22:10
 * @project Poc-Java-Kafka-Producer
 * @author Ratkovski
 */

import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.client.PostClient;
import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.domain.Post;
import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.dto.PostDtoResponse;
import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostClient postClient;

  public Post consulta(String userId){
    final PostDtoResponse postDtoResponse = postClient.getUserId(userId);
    final Post post = PostMapper.INSTANCE.mapFrom(postDtoResponse);
    return post;

  }
}
