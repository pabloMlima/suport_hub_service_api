package com.br.hubsi.suport_hub_service.security;

import com.br.hubsi.suport_hub_service.entity.Role;
import com.br.hubsi.suport_hub_service.entity.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class UsuarioPrincipalImpl implements UserDetails {

    private UUID id;
    private String nome;
    private String email;
    private Collection<? extends GrantedAuthority> roles;
    private Collection<? extends GrantedAuthority> permissions;

    public static UsuarioPrincipalImpl createUserPrincipal(Usuario user) {
        if (user != null) {
            List<GrantedAuthority> roles= user.getRoles().stream().filter(Objects::nonNull)
                    .map(role -> new SimpleGrantedAuthority(role.getNome()))
                    .collect(Collectors.toList());

            List<GrantedAuthority> permissions = user.getRoles().stream().filter(Objects::nonNull)
                    .map(Role::getPermissions).flatMap(Collection::stream)
                    .map(permission-> new SimpleGrantedAuthority(permission.getNome()))
                    .collect(Collectors.toList());

            return UsuarioPrincipalImpl.builder()
                    .id(user.getId())
                    .nome(user.getNome())
                    .email(user.getLogin().getEmail())
                    .roles(roles)
                    .permissions(permissions)
                    .build();
        }
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }
}
