package amirulalfin.carrent.controller;


import amirulalfin.carrent.model.User;
import amirulalfin.carrent.service.UserService;
import amirulalfin.carrent.utils.DTO.UserDTO;
import amirulalfin.carrent.utils.page.PageResponseWrapper;
import amirulalfin.carrent.utils.page.Res;
import jakarta.validation.Valid;
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
    public User create(@Valid @RequestBody UserDTO request) {
        return userService.create(request);

    }
    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size=10)Pageable pageable,
            @RequestParam(required = false) String name
    ) {
        return Res.renderJson(
                new PageResponseWrapper<>(userService.getAll(pageable, name)),
                "KETEMU",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        return Res.renderJson(
                userService.getById(id),
                "found",
                HttpStatus.OK
        );
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
