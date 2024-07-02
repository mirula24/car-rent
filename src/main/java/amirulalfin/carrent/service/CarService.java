package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.utils.DTO.CarDTO;

import java.util.List;

public interface CarService {
    Car create(CarDTO car);
    Car update(Integer id,CarDTO car);
    void delete(Integer id);
    Car getOne(Integer id);
    List<Car> getAll();
}
