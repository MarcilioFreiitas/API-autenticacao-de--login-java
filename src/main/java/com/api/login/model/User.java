package com.api.login.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "User")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID id_user;
    
    @Column(name = "name", unique = false, length = 30, nullable = false)
    private String name;

    @Column(name = "email", unique = true, length = 30, nullable = false)
    private String email;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", unique = false, length = 100, nullable = false)
    private String password;

    public UUID getId_user() {
        return id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Boolean comparePassword(String password){
        if(this.password.equals(password)) return true;
        else return false;
    }

    public String getPassword() {
        return password;
    }
}