package com.microservices.hotelservice.repositories;

import com.microservices.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
