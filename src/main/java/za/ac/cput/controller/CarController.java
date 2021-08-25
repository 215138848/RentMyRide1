package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Car;
import za.ac.cput.factory.CarFactory;
import za.ac.cput.service.CarService;

import java.util.Set;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/create")
    public Car create(@RequestBody Car car) {
        Car newCar = CarFactory.createCar(
                car.getNumberPlate(),
                car.getColor(),
                car.getMake(),
                car.getModel(),
                car.getRentalPrice(),
                car.getLocation(),
                car.availabilityStatus()
        );
        return carService.create(newCar);
    }
    @GetMapping("/read/{numberPlate}")
    public Car read(@PathVariable String numberPlate) {
        return carService.read(numberPlate);
    }

    @RequestMapping("/update")
    public Car update(@RequestBody Car car) {
        Car updateCar = carService.update(car);
        return updateCar;
    }

    @RequestMapping("/delete")
    public String delete(@RequestBody Car car) {
        if(carService.delete(car.getNumberPlate()))
            return "Successfully deleted the record";
        return "An error has occurred while trying to delete this record";
    }

    @RequestMapping("/getall")
    public Set<Car> getAll() {
        return carService.getAll();
    }

}
