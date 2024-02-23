package cl.muruna.registerUsers.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.muruna.registerUsers.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
}
