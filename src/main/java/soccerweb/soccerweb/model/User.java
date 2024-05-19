package soccerweb.soccerweb.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToOne(mappedBy = "user")
    private Player player;
}