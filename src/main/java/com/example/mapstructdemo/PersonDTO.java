package com.example.mapstructdemo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class PersonDTO {
    private Long id;
    private String name;
}
