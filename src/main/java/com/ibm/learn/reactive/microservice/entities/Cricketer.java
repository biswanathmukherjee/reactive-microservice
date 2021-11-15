package com.ibm.learn.reactive.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cricketer")
public class Cricketer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String role;
    private float battingAverage;
    private int wicketsTaken;
    private List<String> teams;

}
