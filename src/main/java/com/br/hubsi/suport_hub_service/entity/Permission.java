package com.br.hubsi.suport_hub_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseEntity{

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;
}