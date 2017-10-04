package com.itmatcher;

import com.itmatcher.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by deant on 9/14/17.
 */
@Configuration
@ComponentScan({ "com.itmatcher" })
public class App {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
    WebConfig config = ctx.getBean(WebConfig.class);
    config.initApplication();
  }
}