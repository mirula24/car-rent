package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.repository.BrandRepository;
import amirulalfin.carrent.service.BrandService;
import amirulalfin.carrent.utils.DTO.BrandDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<Brand> getAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Brand update(Integer id,Brand brand) {
        Brand replace = this.getById(id);
        replace.setName(brand.getName());
        return brandRepository.save(replace);
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);

    }
}
