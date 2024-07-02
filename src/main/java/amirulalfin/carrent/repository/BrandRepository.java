package amirulalfin.carrent.repository;

import amirulalfin.carrent.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
