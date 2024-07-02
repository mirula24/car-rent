package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.model.Rent;
import amirulalfin.carrent.model.User;
import amirulalfin.carrent.repository.RentRepository;
import amirulalfin.carrent.service.CarService;
import amirulalfin.carrent.service.RentService;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.RentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final UserService userService;
    private final CarService carService;

    public RentServiceImpl(RentRepository rentRepository, UserService userService, CarService carService) {
        this.rentRepository = rentRepository;
        this.userService = userService;
        this.carService = carService;
    }

    @Override
    public Rent save(RentDTO rent) {
        Rent rentEntity = new Rent();
        User user = userService.getById(rent.getUser_id());


        Car car = carService.getOne(rent.getCar_id());

        rentEntity.setUser(user);
        rentEntity.setCar(car);
        rentEntity.setCompleted(rent.isCompleted());
        rentEntity.setPrice(rent.getPrice());
        rentEntity.setStarted_at(rent.getStarted_at());
        rentEntity.setEnded_at(rent.getEnded_at());

        return rentRepository.save(rentEntity);
    }

    @Override
    public Rent getOne(Integer id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        rentRepository.deleteById(id);
    }

    @Override
    public Rent update(Integer id, RentDTO rent) {
        Rent update = rentRepository.findById(id).orElse(null);
        User user = userService.getById(rent.getUser_id());
        Car car = carService.getOne(rent.getCar_id());

        assert update != null;
        update.setCompleted(rent.isCompleted());
        update.setPrice(rent.getPrice());
        update.setStarted_at(rent.getStarted_at());
        update.setEnded_at(rent.getEnded_at());
        update.setCar(car);
        update.setUser(user);
        update.setId(id);

        return rentRepository.save(update);
    }
}
