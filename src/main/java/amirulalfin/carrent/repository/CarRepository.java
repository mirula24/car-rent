package amirulalfin.carrent.repository;


import amirulalfin.carrent.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface carRepository extends JpaRepository<Car, Integer> {


}
