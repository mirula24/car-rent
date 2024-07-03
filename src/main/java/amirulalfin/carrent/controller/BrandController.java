package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.service.BrandService;
import amirulalfin.carrent.utils.DTO.BrandDTO;
import amirulalfin.carrent.utils.page.PageResponseWrapper;
import amirulalfin.carrent.utils.page.Res;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
@Validated
public class BrandController
{
    private final BrandService brandService;

    @PostMapping
    public Brand create(@Valid @RequestBody BrandDTO brand){
        return brandService.create(brand);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size=10)Pageable pageable,
            @RequestParam(required = false) String name
    ) {
        return Res.renderJson(
                new PageResponseWrapper<>(brandService.getAll(pageable, name)),
                "KETEMU",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        return Res.renderJson(
                brandService.getById(id),
                "found",
                HttpStatus.OK
        );
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
