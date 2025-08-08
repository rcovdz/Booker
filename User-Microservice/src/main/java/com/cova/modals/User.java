package com.cova.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "First name is required...")
    @Size(max = 30, message = "First name must not exceed 30 characters...")
    private String firstName;

    @NotBlank(message = "Last name is required...")
    @Size(max = 30, message = "Last name must not exceed 30 characters...")
    private String lastName;

    @NotBlank(message = "Username is required...")
    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters...")
    private String username;

    @NotBlank(message = "Email is required...")
    @Email(message = "Please enter a valid email address...")
    private String email;

    @NotBlank(message = "Password is required...")
    @Size(min = 10, max = 30, message = "Password must be between 10 and 30 characters...")
    private String password;

    @Size(min = 10, max = 10, message = "Phone number must have 10 digits...")
    private String phone;

    @NotBlank(message = "Role name is required...")
    private String role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
