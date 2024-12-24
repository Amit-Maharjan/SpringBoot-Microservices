package com.microservices.hotelservice.services;

import com.microservices.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel getById(String hotelId);
}
