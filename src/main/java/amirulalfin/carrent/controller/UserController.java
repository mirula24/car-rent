package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.UserDTO;
import amirulalfin.carrent.utils.page.PageResponseWrapper;
import amirulalfin.carrent.utils.page.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAllStudents(@PageableDefault()Pageable pageable
    ) {

        Page<User> res = userService.getAll(pageable);
        PageResponseWrapper<User> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "Found",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public User getByid(@PathVariable Integer id){
        return userService.getById(id);
    }

    @PutMapping()
    public User update(@RequestBody UserDTO request) {
        return userService.update(request.getId(),request);
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
