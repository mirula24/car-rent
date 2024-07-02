package amirulalfin.carrent.service;

import amirulalfin.carrent.model.User;

import java.util.List;

public interface UserService {
    User create(User Request);
    List<User> getAll();
    User getById(Integer id);
    User update(User Request);
    void delete(Integer id);
    User topUp(Integer id, Integer nominal);

}
