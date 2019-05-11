package com.lesson19.entity;

import com.lesson19.configuration.InjectRandomInt;
import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Employee {

    private String firstName;
    private String lastName;

    @InjectRandomInt(min = 16, max = 99)
    private Integer age;
}
