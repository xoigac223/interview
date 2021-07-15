package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    private String customerPhone;

    private String opinion;

    private Timestamp dateCreated;

    private String answer;

    private boolean isProcessed;

    private String time;
}
