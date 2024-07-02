package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.utils.DTO.BrandDTO;

import java.util.List;

public interface BrandService {
    Brand create(BrandDTO brand);
    Brand getById(Integer id);
    List<Brand> getAll();
    Brand update(Brand brand);
    void delete(Integer id);
}
