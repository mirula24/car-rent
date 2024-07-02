package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.utils.DTO.BrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrandService {
    Brand create(BrandDTO brand);
    Brand getById(Integer id);
    Page<Brand> getAll(Pageable pageable);
    Brand update(Brand brand);
    void delete(Integer id);
}
