package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostDtoResponse {
  @JsonProperty
  private String userId;
  @JsonProperty
  private String id;
  @JsonProperty
  private String title;
  @JsonProperty
  private String body;
}
