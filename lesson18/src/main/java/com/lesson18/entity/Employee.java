package com.lesson18.entity;

import com.lesson18.configuration.InjectRandomInt;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
