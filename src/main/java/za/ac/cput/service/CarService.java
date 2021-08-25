/*
    @title: CarService ->
    @Author: Rick Allen Herbert
    @Student Number: 219014337
    @Date: 1 August 2021
*/
package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Car;
import za.ac.cput.repository.car.CarRepository;
import za.ac.cput.service.car.ICarService;

import java.util.Set;

@Service
public class CarService implements ICarService {
    private static CarService service = null;
    private CarRepository repository = null;

    private CarService() {
        this.repository = CarRepository.getRepository();
    }

    public static CarService getService(){
        if(service == null){
            service = new CarService();
        }
        return service;
    }
    @Override
    public Car create(Car car) {
        return this.repository.create(car);
    }

    @Override
    public Car read(String numberPlate) {
        return this.repository.read(numberPlate);
    }

    @Override
    public Car update(Car car) {
        return this.repository.update(car);
    }

    @Override
    public boolean delete(String numberPlate) {
        return this.repository.delete(numberPlate);
    }

    @Override
    public Set<Car> getAll() {
        return this.repository.getAll();
    }
}
