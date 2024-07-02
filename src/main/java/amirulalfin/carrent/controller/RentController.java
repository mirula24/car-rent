package amirulalfin.carrent.controller;

import amirulalfin.carrent.model.Rent;
import amirulalfin.carrent.service.RentService;
import amirulalfin.carrent.utils.DTO.RentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
@RequiredArgsConstructor
public class RentController {
    private final RentService rentService;

    @GetMapping
    public List<Rent> getAll(){
        return rentService.getAll();
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
    public Rent create(@RequestBody RentDTO rentDTO){
        return rentService.save(rentDTO);
    }
}
