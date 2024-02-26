package cl.muruna.registerUsers.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.muruna.registerUsers.model.Phone;
import cl.muruna.registerUsers.model.User;
import cl.muruna.registerUsers.repository.PhoneNumberRepository;
import cl.muruna.registerUsers.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    @Override
    public User addUser(User user) {

        User userExist=findUserByEmail(user.getEmail());
        if(userExist==null){
            User savedUser = userRepository.save(user);
            for(Phone phone : user.getPhones()){
                phone.setUser(savedUser);
                phoneNumberRepository.save(phone);
            }
            return savedUser;
        }else{
            throw new RuntimeException("Email already exist");
        }
             
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);       
        return user;       
    }

    @Override
    public List<User> findAllUser() {
        List<User> allUser = userRepository.findAll();
        if(allUser.isEmpty()){
            throw new RuntimeException("Users not exist in data base");
        }else{
            return allUser;
        }
    }

    @Override
    public void deleteUser(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if(user.isEmpty()){
            throw new RuntimeException("User not exist");
        }else{
            userRepository.deleteById(uuid);
        }
    }

    @Override
    public Optional<User> findUserByUUI(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if(user.isEmpty()){
            throw new RuntimeException("User not exist");
        }else{
            return user;           
        }
    } 
    
    @Override
    public User updateUser(User newUser, UUID uuid) {
        return userRepository.findById(uuid)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setPhones(newUser.getPhones());
                    user.setModified(new Timestamp(System.currentTimeMillis()));
                    user.setLastLogin(new Timestamp(System.currentTimeMillis()));
                    User userUpdate = userRepository.save(user);
                    for(Phone phone : user.getPhones()){
                        phone.setUser(userUpdate);
                        phoneNumberRepository.save(phone);
                    }
                    return userUpdate;
                })
                .orElseGet(() -> {
                    newUser.setId(uuid);
                    return userRepository.save(newUser);
                });
    }
}
