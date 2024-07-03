package amirulalfin.carrent.controller;

import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.CarService;
import amirulalfin.carrent.utils.DTO.CarDTO;
import amirulalfin.carrent.utils.page.PageResponseWrapper;
import amirulalfin.carrent.utils.page.Res;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Validated
public class CarController {
    private final CarService carService;

  @GetMapping
  public ResponseEntity<?> getAllCar(@PageableDefault(size=10) Pageable pageable,@RequestParam(required = false) String name,@RequestParam(required = false)Boolean available
  ) {

    Page<Car> res = carService.getAll(pageable,name,available);
    PageResponseWrapper<Car> result = new PageResponseWrapper<>(res);
    return Res.renderJson(
            result,
            "KETEMU",
            HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
    public Car getOne(@PathVariable Integer id) {
      return carService.getOne(id);
  }

  @PostMapping
    public Car save(@Valid @RequestBody CarDTO car) {
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
