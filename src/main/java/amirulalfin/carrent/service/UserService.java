package amirulalfin.carrent.service;

import amirulalfin.carrent.model.User;
import amirulalfin.carrent.utils.DTO.UserDTO;

import java.util.List;

public interface UserService {
    User create(UserDTO Request);
    List<User> getAll();
    User getById(Integer id);
    User update(User Request);
    void delete(Integer id);
    User topUp(Integer id,Integer topUp);

}
