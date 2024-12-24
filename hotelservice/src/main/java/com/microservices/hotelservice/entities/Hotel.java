package com.microservices.hotelservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @Column(name = "id")
    private String hotelId;
    private String name;
    private String address;
    private String description;
}
