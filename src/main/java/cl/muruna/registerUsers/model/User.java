package cl.muruna.registerUsers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


 
@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column
    @NotBlank(message = "Please add name")
    private String name;

    @Email(message = "The email is not valid.")
    @NotBlank(message = "Please add email")
    private String email;

    @NotBlank(message = "Please add password")
    private String password;  
    
    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp modified;

    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastLogin;

    @Column
    private String token;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Valid
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Phone> phones = new ArrayList<>();

}
