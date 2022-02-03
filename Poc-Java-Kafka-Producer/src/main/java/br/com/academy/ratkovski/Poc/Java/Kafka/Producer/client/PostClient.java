package br.com.academy.ratkovski.Poc.Java.Kafka.Producer.client;

import br.com.academy.ratkovski.Poc.Java.Kafka.Producer.dto.PostDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(name = "post", url = "https://jsonplaceholder.typicode.com/")
//@FeignClient(name = "post", url = "http://localhost:1456/")
public interface PostClient {

  @RequestMapping(method = RequestMethod.GET, value = "posts/{userId}", consumes = "application/json")
  PostDtoResponse getUserId(@PathVariable("userId") String userId);

}

