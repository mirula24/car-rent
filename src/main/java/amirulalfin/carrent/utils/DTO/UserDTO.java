package amirulalfin.carrent.utils.DTO;

import amirulalfin.carrent.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    @NotBlank
    private String name;

    private Integer Balance;

    private Integer id;

    public UserDTO parse(User user){
        this.name = user.getName();
        this.Balance = user.getBalance();
        this.id = user.getId();
        return this;
    }
}