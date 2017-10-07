package com.itmatcher.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by deant on 10/5/17.
 */
@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("sql/create-db.sql")
                .addScript("sql/insert-data.sql")
                .build();
        return db;
    }

}
