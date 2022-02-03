package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {

  private String userId;
  private String id;
  private String title;
  private String body;

}
