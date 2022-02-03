package br.com.academy.ratkovski.Poc.Java.Kafka.Consumer.domain;

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

  public Post() {
  }

  public Post(String userId, String id, String title, String body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }
}
