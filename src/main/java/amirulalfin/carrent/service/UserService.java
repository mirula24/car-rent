package amirulalfin.carrent.service;

import amirulalfin.carrent.model.User;
import amirulalfin.carrent.utils.DTO.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User create(UserDTO Request);
    Page<User> getAll(Pageable pageable);
    User getById(Integer id);
    User update(Integer id,UserDTO Request);
    void delete(Integer id);
    User topUp(Integer id,Integer topUp);

}
