package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    private String customerPhone;

    private String content;

    private Timestamp dateCreated;
}
