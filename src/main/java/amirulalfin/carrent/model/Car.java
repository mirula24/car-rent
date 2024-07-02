package amirulalfin.carrent.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private boolean available;
    private Integer price;
}
