package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.utils.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {
    Car create(CarDTO car);
    Car update(Integer id,CarDTO car);
    void delete(Integer id);
    Car getOne(Integer id);
    Page<Car> getAll(Pageable pageable,String name,Boolean active);
}
