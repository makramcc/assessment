package com.kbtg.bootcamp.posttest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lottery")
@Data
public class Lottery {
    @Id
    private String ticketId;
    private int price;
    private int amount;
}
