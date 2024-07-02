package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController
{
    private final BrandService brandService;

    @PostMapping
    public Brand create(@RequestBody Brand brand){
        return brandService.create(brand);
    }

    @GetMapping
    public List<Brand> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public Brand getByid(@PathVariable Integer id){
        return brandService.getById(id);
    }
    @PutMapping
    public Brand update(@RequestBody Brand brand){
        return brandService.update(brand);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Integer id){
        brandService.delete(id);
    }
}
