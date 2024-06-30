package com.br.hubsi.suport_hub_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Login extends BaseEntity{

    @Column(name = "email", nullable = false, length = 60)
    private String email;

    @Column(name = "senha", nullable = false, length = 60)
    private String senha;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
