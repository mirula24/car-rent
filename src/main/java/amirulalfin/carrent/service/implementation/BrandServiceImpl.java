package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.repository.BrandRepository;
import amirulalfin.carrent.service.BrandService;
import amirulalfin.carrent.utils.DTO.BrandDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    @Override
    public Brand create(BrandDTO brand) {
        Brand brandEntity = new Brand();
        brandEntity.setName(brand.getName());
        return brandRepository.save(brandEntity);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand update(Brand brand) {
        Brand replace = this.getById(brand.getId());
        replace.setName(brand.getName());
        return brandRepository.save(replace);
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);

    }
}
