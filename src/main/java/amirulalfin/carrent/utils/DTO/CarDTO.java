package amirulalfin.carrent.utils.DTO;

import amirulalfin.carrent.model.Car;
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


    public CarDTO parse(Car request) {
       this.id = request.getId();
       this.name = request.getName();
       this.brand_id = request.getBrand().getId();
       this.available = request.isAvailable();
       this.price = request.getPrice();

        return this;
    }
}
