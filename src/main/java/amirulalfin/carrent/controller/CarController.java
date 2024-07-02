package amirulalfin.carrent.controller;

import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.service.CarService;
import amirulalfin.carrent.utils.DTO.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

  @GetMapping
    public List<Car> findAll() {
      return carService.getAll();
  }

  @GetMapping("/{id}")
    public Car getOne(@PathVariable Integer id) {
      return carService.getOne(id);
  }

  @PostMapping
    public Car save(@RequestBody CarDTO car) {
      return carService.create(car);
  }

  @PutMapping
    public Car update(@RequestBody CarDTO car) {
      return carService.update(car.getId(),car);
  }

  @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
      carService.delete(id);
  }
}
