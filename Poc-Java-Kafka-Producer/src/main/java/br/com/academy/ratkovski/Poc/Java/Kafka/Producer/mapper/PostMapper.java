package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.mapper;/*
 * @created 29/01/2022 - 21:43
 * @project Poc-Java-Kafka-Producer
 * @author Ratkovski
 */

import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.domain.Post;
import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.dto.PostDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
  PostMapper INSTANCE  = Mappers.getMapper(PostMapper.class);
  Post mapFrom(final PostDtoResponse postDtoResponse);
}
