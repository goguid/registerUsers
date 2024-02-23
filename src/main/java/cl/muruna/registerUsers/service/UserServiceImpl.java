package cl.muruna.registerUsers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.muruna.registerUsers.model.User;
import cl.muruna.registerUsers.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }


    
}
