package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.service.BrandService;
import amirulalfin.carrent.utils.DTO.BrandDTO;
import amirulalfin.carrent.utils.page.PageResponseWrapper;
import amirulalfin.carrent.utils.page.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController
{
    private final BrandService brandService;

    @PostMapping
    public Brand create(@RequestBody BrandDTO brand){
        return brandService.create(brand);
    }

    @GetMapping
    public ResponseEntity<?> getAllBrand(@PageableDefault() Pageable pageable
    ) {

        Page<Brand> res = brandService.getAll(pageable);
        PageResponseWrapper<Brand> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "KETEMU",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Brand getByid(@PathVariable Integer id){
        return brandService.getById(id);
    }
    @PutMapping
    public Brand update(@RequestBody Brand brand){
        return brandService.update(brand.getId(),brand);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        brandService.delete(id);
    }
}
