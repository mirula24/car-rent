package amirulalfin.carrent.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "rents")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date started_at;
    private Date ended_at;
    private Integer price;
}
