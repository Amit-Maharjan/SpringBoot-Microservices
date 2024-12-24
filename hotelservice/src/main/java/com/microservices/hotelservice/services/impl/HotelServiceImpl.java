package com.microservices.hotelservice.services.impl;

import com.microservices.hotelservice.entities.Hotel;
import com.microservices.hotelservice.exceptions.ResourceNotFoundException;
import com.microservices.hotelservice.repositories.HotelRepository;
import com.microservices.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() ->
                new ResourceNotFoundException("Hotel with the given id not found !!")
        );
    }
}