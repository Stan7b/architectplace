package com.architect.api.ArchitectPlace.entity;


import com.architect.api.ArchitectPlace.entity.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usr", indexes = {@Index(name = "gender_fk_index", columnList = "gender_id")})
@EqualsAndHashCode(of = "username")
@ToString(exclude = {"gender", "project"})
public class User extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @OneToMany(mappedBy = "user")
    private List<Project> projects;


}
