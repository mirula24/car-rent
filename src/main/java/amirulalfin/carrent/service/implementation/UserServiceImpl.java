package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.User;
import amirulalfin.carrent.repository.UserRepository;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(UserDTO Request) {
        User user = new User();
        user.setName(Request.getName());
        user.setBalance(Request.getBalance());
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(Integer id,UserDTO request){
        User req = userRepository.findById(id).orElse(null);
        req.setName(request.getName());
        req.setBalance(request.getBalance());
        return userRepository.save(req);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User topUp(Integer id,Integer topup) {
        User req = userRepository.findById(id).orElse(null);
        Integer total = req.getBalance() + topup;
        req.setBalance(total);
        return userRepository.save(req);
    }
}
