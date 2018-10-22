package com.yunjae.springr2dbc.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
public class Coffee {
    @Id
    private Long id;

    @NonNull
    private String name;
}
