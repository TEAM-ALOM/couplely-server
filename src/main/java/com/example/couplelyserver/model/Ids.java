package com.example.couplelyserver.model;

import jakarta.persistence.*;

@Entity
@Table(name="IDS")
public class Ids {
    @Id
    private Long id;
    @Column
    private int sessionId;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;  //사실 잘 모르겠음



}
