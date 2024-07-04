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
    private String username;
    private Integer Balance;
    private Integer id;

    public UserDTO parse(User user){
        this.name = user.getName();
        this.username = user.getUsername();
        this.Balance = user.getBalance();
        this.id = user.getId();
        return this;
    }
}