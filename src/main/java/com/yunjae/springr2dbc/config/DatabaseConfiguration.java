package com.yunjae.springr2dbc.config;

import com.yunjae.springr2dbc.repository.CoffeeRepository;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

@Configuration
public class DatabaseConfiguration {
    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .database("postgres")
                .username("postgres")
                .password("wofl07")
                .build()
        );
    }

    @Bean
    DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();
    }

    @Bean
    R2dbcRepositoryFactory repositoryFactory(DatabaseClient client) {
        RelationalMappingContext context = new RelationalMappingContext();
        context.afterPropertiesSet();

        return new R2dbcRepositoryFactory(client, context);
    }

    @Bean
    CoffeeRepository coffeeReposity(R2dbcRepositoryFactory factory) {
        return factory.getRepository(CoffeeRepository.class);
    }

}
