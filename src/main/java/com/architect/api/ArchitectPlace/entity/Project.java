package com.architect.api.ArchitectPlace.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project", indexes = {@Index(name = "user_fk_index", columnList = "user_id")})
@EqualsAndHashCode
@ToString(exclude = "user")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true)
    private String header;

    private String discriptions;

    private Integer view = 0;

    private Integer price;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
