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

    @NotBlank
    private Integer car_id;
    @NotBlank
    private Integer user_id;
    @NotBlank
    private Date started_at;
    @NotBlank
    private Date ended_at;
}
