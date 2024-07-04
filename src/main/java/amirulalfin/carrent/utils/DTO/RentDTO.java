package amirulalfin.carrent.utils.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentDTO {

    @NotNull
    private Integer car_id;
    @NotNull
    private Integer user_id;
    private Date started_at;

    private Date ended_at;
}
