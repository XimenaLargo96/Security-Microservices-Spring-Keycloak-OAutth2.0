package com.msbills.Security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;
import java.util.stream.Collectors;

public class JwtAuthConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        Map<String, Object> realmRolesAccess = source.getClaim("realm_access");

        List<String> realmGroups = source.getClaim("Group");

        if (realmRolesAccess != null && !realmRolesAccess.isEmpty()) {
            authorities.addAll(extractRoles(realmRolesAccess));
            authorities.addAll(extracGroups(realmGroups));
        }

        return authorities;
    }

    private static  Collection<GrantedAuthority> extractRoles(Map<String, Object> realmRolesAccess){
        return ((List<String>) realmRolesAccess.get("roles"))
                .stream().map(roleMap -> "ROLE_" + roleMap)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private static Collection<GrantedAuthority>  extracGroups(List<String> realmGroupsAccess){
        return realmGroupsAccess.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }
}
