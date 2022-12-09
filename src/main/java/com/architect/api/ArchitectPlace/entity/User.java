package com.architect.api.ArchitectPlace.entity;


import com.architect.api.ArchitectPlace.entity.enums.UserStatus;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String email;

    private String username;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Gender gender;



}
