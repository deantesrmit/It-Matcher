package com.itmatcher;

import com.itmatcher.config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * App Class - The main application class for running the app
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Configuration
@ComponentScan({ "com.itmatcher" })
public class App {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
    WebConfig config = ctx.getBean(WebConfig.class);
    config.initApplication();
    org.hsqldb.util.DatabaseManagerSwing.main(new String[] {
      "--url",  "jdbc:hsqldb:mem:testdb", "--noexit"
    });
  }
}