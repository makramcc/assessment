package com.kbtg.bootcamp.posttest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_ticket")
@Data
public class UserTicket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String ticketId;
}
