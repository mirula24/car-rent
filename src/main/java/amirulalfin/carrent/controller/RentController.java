package amirulalfin.carrent.controller;

import amirulalfin.carrent.model.Rent;
import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.RentService;
import amirulalfin.carrent.utils.DTO.RentDTO;
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

import java.util.List;

@RestController
@RequestMapping("/rents")
@RequiredArgsConstructor
@Validated
public class RentController {
    private final RentService rentService;

    @GetMapping
    public ResponseEntity<?> getAllRent(@PageableDefault(size=10) Pageable pageable
    ) {
        Page<Rent> res = rentService.getAll(pageable);
        PageResponseWrapper<Rent> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "KETEMU",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Rent getById(@PathVariable Integer id){
        return rentService.getOne(id);
    }

    @PutMapping("/{id}")
    public Rent update(@PathVariable Integer id){
        return rentService.update(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        rentService.delete(id);
    }

    @PostMapping
    public Rent create(@Valid @RequestBody RentDTO rentDTO){
        return rentService.save(rentDTO);
    }
}
