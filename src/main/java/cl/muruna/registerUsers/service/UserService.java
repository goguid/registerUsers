package cl.muruna.registerUsers.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cl.muruna.registerUsers.model.User;

public interface UserService {

    public User addUser(User user);

    public User findUserByEmail(String email);

    public Optional<User> findUserByUUI(UUID uuid);

    public List<User> findAllUser();

    public void deleteUser(UUID uuid);

    public User updateUser(User newUser, UUID uuid);
    
}
