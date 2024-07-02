package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Brand;

import java.util.List;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    List<Brand> getAll();
    Brand update(Brand brand);
    void delete(Integer id);
}
