package com.br.hubsi.suport_hub_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends BaseEntity{

    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "sobrenome", nullable = false, length = 30)
    private String sobrenome;

    @Column(name = "cpf", nullable = false, length = 15)
    private String cpf;

    @OneToOne(mappedBy = "usuario")
    private Login login;

    @Column(name="data_nascimento")
    private Date dataNascimento;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
