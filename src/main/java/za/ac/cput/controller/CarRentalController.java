package za.ac.cput.controller;

/*
    @title: CarRentalController
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 16 August 2021
  */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.entity.CarRental;
import za.ac.cput.factory.CarRentalFactory;
import za.ac.cput.service.CarRentalService;

import java.util.Set;

public class CarRentalController {

    @Autowired
    private CarRentalService carRentalService;

    @RequestMapping(value = "/create")
    public CarRental create(@RequestBody CarRental carRental){
        CarRental newCarRental = CarRentalFactory.createCarRental(
                carRental.getClientID(),
                carRental.getNumberPlate(),
                carRental.getEmployeeNumber(),
                carRental.getRentalStartDate(),
                carRental.getRentalEndDate()
        );
        return CarRentalService.getService().create(newCarRental);
    }

    @GetMapping("/read/{rentalID}")
    public CarRental read(@PathVariable String rentalID){
        return CarRentalService.getService().read(rentalID);
    }

    @RequestMapping("/update")
    public CarRental update(@RequestBody CarRental carRental){
        CarRental updateCarRental = carRentalService.update(carRental);
        return updateCarRental;
    }

    @RequestMapping("/delete")
    public String delete(@RequestBody CarRental carRental){
        if (CarRentalService.getService().delete(carRental.getRentalID()))
            return "Record has been deleted";
        return "Deletion Failed";
    }

    @RequestMapping("/getAll")
    public Set<CarRental> getAll(){
        return CarRentalService.getService().getAll();
    }
}
