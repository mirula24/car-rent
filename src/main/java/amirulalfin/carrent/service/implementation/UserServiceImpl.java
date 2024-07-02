package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.User;
import amirulalfin.carrent.repository.UserRepository;
import amirulalfin.carrent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User create(User Request) {
        return userRepository.save(Request);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User Request) {
        User user =this.getById(Request.getId());
        user.setName(Request.getName());
        user.setBalance(Request.getBalance());
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User topUp(Integer id, Integer nominal) {
        User user = this.getById(id);
        user.setBalance(nominal);
        return userRepository.save(user);
    }
}
