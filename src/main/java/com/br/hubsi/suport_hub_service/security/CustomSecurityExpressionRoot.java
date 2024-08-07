package com.br.hubsi.suport_hub_service.security;

import io.micrometer.common.util.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;

    /**
     * Creates a new instance
     *
     * @param authentication the {@link Authentication} to use. Cannot be null.
     */
    public CustomSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean hasAnyPermission(String... permissions) {
        UsuarioPrincipalImpl authentication = (UsuarioPrincipalImpl) getPrincipal();
        for (String permission : permissions) {
            if (authentication.getPermissions()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(a -> a.equals(permission))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates if Current User is authorized for ALL given permissions
     *
     * @param permissions cannot be empty
     */
    public boolean hasPermission(String... permissions) {
        UsuarioPrincipalImpl authentication = (UsuarioPrincipalImpl) getPrincipal();
        if (CollectionUtils.isNotEmpty(authentication.getPermissions())) {
            List<String> authenticationPermissions = authentication.getPermissions()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return Arrays.stream(permissions)
                    .filter(StringUtils::isNotBlank)
                    .allMatch(permission -> authenticationPermissions.contains(permission));
        }
        return false;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return target;
    }

    public void setThis(Object target) {
        this.target = target;
    }
}