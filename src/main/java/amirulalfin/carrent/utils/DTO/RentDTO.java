package amirulalfin.carrent.utils.DTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentDTO {
    private Integer car_id;
    private Integer user_id;
    private Date started_at;
    private Date ended_at;
}
