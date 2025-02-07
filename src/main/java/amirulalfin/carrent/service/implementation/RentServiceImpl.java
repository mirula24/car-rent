package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.Car;
import amirulalfin.carrent.model.Rent;
import amirulalfin.carrent.model.User;
import amirulalfin.carrent.repository.RentRepository;
import amirulalfin.carrent.service.CarService;
import amirulalfin.carrent.service.RentService;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.CarDTO;
import amirulalfin.carrent.utils.DTO.RentDTO;
import amirulalfin.carrent.utils.DTO.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        rentEntity.setCompleted(false);
        rentEntity.setPrice(car.getPrice());
        rentEntity.setStarted_at(rent.getStarted_at());
        rentEntity.setEnded_at(rent.getEnded_at());

        return rentRepository.save(rentEntity);
    }

    @Override
    public Rent getOne(Integer id) {
        return rentRepository.findById(id).orElseThrow(() -> new RuntimeException("Rent with id: " + id +
                " not found"));
    }

    @Override
    public Page<Rent> getAll(Pageable pageable) {
        return rentRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        rentRepository.deleteById(id);
    }

    @Override
    public Rent update(Integer id) {
        Rent update = rentRepository.findById(id).orElse(null);
        assert update != null;
        User user = userService.getById(update.getUser().getId());
        Car car = carService.getOne(update.getCar().getId());

        update.setCompleted(true);

        
        CarDTO carDTO = new CarDTO().parse(car);
         carDTO.setAvailable(true);

        carService.update(car.getId(),carDTO);

        if(update.getEnded_at().after(new Date()))  {
            update.setPrice((int) (car.getPrice() * 1.1));
        }

        UserDTO userDTO = new UserDTO().parse(user);
        userDTO.setBalance(user.getBalance() - update.getPrice());

        userService.update(user.getId(),userDTO);

        return rentRepository.save(update);
    }
}
