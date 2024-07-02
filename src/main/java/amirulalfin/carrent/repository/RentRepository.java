package amirulalfin.carrent.repository;

import amirulalfin.carrent.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {
}
