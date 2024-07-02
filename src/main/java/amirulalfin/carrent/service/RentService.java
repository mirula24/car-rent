package amirulalfin.carrent.service;

import amirulalfin.carrent.model.Rent;
import amirulalfin.carrent.utils.DTO.RentDTO;

import java.util.List;

public interface RentService {
    Rent save(RentDTO rent);
    Rent getOne(Integer id);
    List<Rent> getAll();
    void delete(Integer id);
    Rent update(Integer id);
}
