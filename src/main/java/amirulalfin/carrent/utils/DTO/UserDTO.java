package amirulalfin.carrent.utils.DTO;

import amirulalfin.carrent.model.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private String name;
    private Integer Balance;

    public UserDTO parse(User user){
        this.name = user.getName();
        this.Balance = user.getBalance();
        return this;
    }
}