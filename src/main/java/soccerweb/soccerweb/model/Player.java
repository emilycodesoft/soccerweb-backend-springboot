package soccerweb.soccerweb.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    private PlayerType playerType;

    private String name;
    private String lastName;
    private String address;
    private int age;
    private boolean deleted = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private boolean penalized;
}

enum Role {
    ADMIN, PLAYER
}

enum PlayerType {
    frecuente, ocasional
}