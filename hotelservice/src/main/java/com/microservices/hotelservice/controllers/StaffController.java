package com.microservices.hotelservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @GetMapping
    public ResponseEntity<List<String>> getStaffs() {
        List<String> staffs = new ArrayList<>();
        staffs.add("John Doe");
        staffs.add("Jane Doe");
        staffs.add("Jack Doe");
        return ResponseEntity.ok(staffs);
    }
}
