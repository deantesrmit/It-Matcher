package com.itmatcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Database config - A class which fills the database with the required scripts for the application
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("sql/create-db.sql")
                .addScript("sql/insert-profile-data.sql")
                .addScript("sql/insert-job-data.sql")
                .addScript("sql/insert-education-data.sql")
                .addScript("sql/insert-workexperience-data.sql")
                .build();
        return db;
    }

}
