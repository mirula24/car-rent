package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.repository.CarRepository;
import amirulalfin.carrent.service.BrandService;
import amirulalfin.carrent.service.CarService;
import amirulalfin.carrent.utils.DTO.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final BrandService brandService;

    public CarServiceImpl(CarRepository carRepository, BrandService brandService) {
        this.carRepository = carRepository;
        this.brandService = brandService;
    }


    @Override
    public Car create(CarDTO car) {
        Brand brand = brandService.getById(car.getBrand_id());
        Car carEntity = new Car();
        carEntity.setBrand(brand);
        carEntity.setName(car.getName());
        carEntity.setPrice(car.getPrice());
        carEntity.setAvailable(car.isAvailable());
        return carRepository.save(carEntity);
    }

    @Override
    public Car update(Integer id,CarDTO car) {
        Brand brand = brandService.getById(car.getBrand_id());
        Car c = this.getOne(id);
        c.setName(car.getName());
        c.setBrand(brand);
        c.setAvailable(car.isAvailable());
        c.setPrice(car.getPrice());

        return carRepository.save(c);
    }

    @Override
    public void delete(Integer id) {
            carRepository.deleteById(id);
    }

    @Override
    public Car getOne(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Car> getAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
