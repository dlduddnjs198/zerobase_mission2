package com.zerobase.mission2.domain;

import jakarta.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;
}
