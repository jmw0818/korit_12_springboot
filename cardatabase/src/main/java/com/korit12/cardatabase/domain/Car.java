package com.korit12.cardatabase.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String brand, model, color, registrationNumber;

    @NonNull
    private int modelYear, price;

    @ManyToOne
    @JoinColumn(name = "owner")
    @NonNull
    private Owner owner;        // @NonNull이 없으니 옵셔널이라고 볼 수 있다.
}
