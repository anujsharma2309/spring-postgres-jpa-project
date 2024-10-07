package com.postgres_demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_role_mapping")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
