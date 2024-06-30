package com.br.hubsi.suport_hub_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @Column(name = "data_cadastro", nullable = false)
    @CreationTimestamp
    private Date dataCadastro;

    @Column(name = "data_alteracao")
    @UpdateTimestamp
    private Date dataAlteracao;

    @Column(name = "ativo", nullable = false, columnDefinition = "boolean default true")
    private boolean ativo;
}
