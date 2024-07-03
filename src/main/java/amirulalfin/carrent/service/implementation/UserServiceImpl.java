package amirulalfin.carrent.service.implementation;

import amirulalfin.carrent.model.Brand;
import amirulalfin.carrent.model.User;
import amirulalfin.carrent.repository.UserRepository;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.UserDTO;
import amirulalfin.carrent.utils.specification.BrandSpecification;
import amirulalfin.carrent.utils.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
    public Page<User> getAll(Pageable pageable,String name) {
        Specification<User> spec = UserSpecification.byUsername(name);
        return userRepository.findAll(spec,pageable);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(Integer id,UserDTO request){
        User req = userRepository.findById(id).orElse(null);
        assert req != null;
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
        assert req != null;
        Integer total = req.getBalance() + topup;
        req.setBalance(total);
        return userRepository.save(req);
    }
}
