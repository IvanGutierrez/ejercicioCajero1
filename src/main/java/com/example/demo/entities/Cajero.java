package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cajero")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cajero {
    @Id
    private int id;
    private Double monto_inicial;
    private int bill_1000;
    private int bill_500;
    private int bill_200;
    private int bill_100;
    private int bill_50;
    private int bill_20;
    private int mon_10;
    private int mon_5;
    private int mon_2;
    private int mon_1;
    private int mon_50C;

}
