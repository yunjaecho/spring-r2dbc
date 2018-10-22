package com.yunjae.springr2dbc.repository;

import com.yunjae.springr2dbc.entity.Coffee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CoffeeRepository extends ReactiveCrudRepository<Coffee, Long> {
    @Query("DELETE FROM coffee")
    Mono<Coffee> deleteAllById();




}
