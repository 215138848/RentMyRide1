package za.ac.cput.controller;

/*
    @title: CarRentalController
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 16 August 2021
  */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.CarRental;
import za.ac.cput.factory.CarRentalFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CarRentalControllerTest {

    private static CarRental carRental = CarRentalFactory.createCarRental("client01","2cool4u","1000001","20-06-2021","28-06-2021");
    @Autowired
    private TestRestTemplete restTemplete;

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}