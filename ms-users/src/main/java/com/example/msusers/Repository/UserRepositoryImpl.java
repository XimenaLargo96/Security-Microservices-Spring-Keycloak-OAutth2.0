package com.example.msusers.Repository;

import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository{

    @Value("${dh.keycloak.realm}")
    private String realm;

    private final Keycloak keycloakClient;

    public Optional<User> findUserByCustomerId(String id) {
        UserRepresentation userRepresentation = keycloakClient.realm(realm).users().get(id).toRepresentation();
        return Optional.of(fromUserRepresentation(userRepresentation));
    }

    private User fromUserRepresentation (UserRepresentation userRepresentation){
        return new User(userRepresentation.getId(), userRepresentation.getFirstName(), userRepresentation.getLastName(), userRepresentation.getEmail());
    }
}
