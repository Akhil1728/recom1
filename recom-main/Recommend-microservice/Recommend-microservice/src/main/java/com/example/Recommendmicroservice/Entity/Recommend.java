package com.example.Recommendmicroservice.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recommend {
    private Long destId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recommendationId;
    private String author;
    private String content;
    private int rate;
}
