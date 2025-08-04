package dev.java10x.service;
import dev.java10x.domain.Users;
import dev.java10x.exceptions.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public Users createUser(Users users) {
        Users.persist(users);
        return users;
    }

    public List<Users> findAllUsers(Integer page, Integer pagesSize ) {
        return Users.findAll()
                .page(page, pagesSize)
                .list();
    }

    public Users findUserById (UUID userId) {
        return (Users) Users.findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public Users updateUser(UUID userId, Users users) {
        var user = findUserById(userId);
        user.username = users.username;
        user.email = users.email;
        Users.persist(user);
        return user;
    }

    public void deleteUser(UUID userId) {
        var user = findUserById(userId);
        Users.deleteById(user.id);
    }


}
