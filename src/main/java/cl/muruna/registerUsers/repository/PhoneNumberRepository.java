package cl.muruna.registerUsers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.muruna.registerUsers.model.Phone;

public interface PhoneNumberRepository extends JpaRepository<Phone,Long> {
        
}
