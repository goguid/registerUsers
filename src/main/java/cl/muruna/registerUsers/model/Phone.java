package cl.muruna.registerUsers.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;

//import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="phonesusers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Please add a number ")
    private String number;

    @NotBlank(message = "Please add a city code ")
    private String citycode;

    @NotBlank(message = "Please add a country code ")
    private String countrycode;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "user_uuid", nullable = false )
    private User user;
    
}
