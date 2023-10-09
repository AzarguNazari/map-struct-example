package com.example.mapstructdemo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Builder
@Getter
public class Person {
    private Long id;
    private String name;
}
