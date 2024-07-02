package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User request) {
        return userService.create(request);

    }
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getByid(@PathVariable Integer id){
        return userService.getById(id);
    }

    @PutMapping
    public User update(@RequestBody User request) {
        return userService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public User topUp(@PathVariable Integer id,@PathVariable Integer nominal) {
        User user = userService.getById(id);
        user.setBalance(user.getBalance()+nominal);
       return userService.topUp(id, user.getBalance());
    }
}
