package com.korit12.cardatabase.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private Long ownerId;

    @Getter @Setter @NonNull
    private String firstName, lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @Getter @Setter
    private List<Car> cars;
}

