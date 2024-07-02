package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Rent;
import amirulalfin.carrent.utils.DTO.RentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RentService {
    Rent save(RentDTO rent);
    Rent getOne(Integer id);
    Page<Rent> getAll(Pageable pageable);
    void delete(Integer id);
    Rent update(Integer id);
}
