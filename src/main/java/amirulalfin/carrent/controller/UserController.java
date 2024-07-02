package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody UserDTO request) {
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

    @PutMapping("/update")
    public User update(@RequestBody Integer id,@RequestBody UserDTO request) {
        return userService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @PostMapping("/{id}/{topup}")
    public User topUp(@PathVariable Integer id,@PathVariable Integer topup) {
       return userService.topUp(id,topup);
    }
}
