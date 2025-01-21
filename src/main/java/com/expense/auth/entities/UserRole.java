package com.expense.auth.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_roles")
public class UserRole {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "role_id")
     private long roleId;

     private String name;

     
}

