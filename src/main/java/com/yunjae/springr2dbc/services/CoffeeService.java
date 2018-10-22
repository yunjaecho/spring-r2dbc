package com.yunjae.springr2dbc.services;

import com.yunjae.springr2dbc.entity.Coffee;
import com.yunjae.springr2dbc.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository repository;

    @PostConstruct
    private void load() {
        repository.deleteAllById()
                .thenMany(
                        Flux.just("Peet's coffe", "Philz Coffee", "Blue Bottle Coffee")
                        .map(Coffee::new)
                        .flatMap(repository::save)
                )
                .thenMany(repository.findAll())
                .subscribe(System.out::println);
    }
}
