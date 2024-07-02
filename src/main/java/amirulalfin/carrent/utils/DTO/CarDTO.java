package amirulalfin.carrent.utils.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarDTO {
    private Integer id;
    private String name;
    private Integer brand_id;
    private boolean available;
    private Integer price;
}
