package com.example.recipeapp.model;

import jakarta.persistence.*;

@Entity
public class Marketing {

    @Id
    @Column(nullable = false)
    private String email;

    @Column(name = "opt_int", nullable = false)
    private Boolean optIn;

    public Marketing() {
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getOptIn() {
        return this.optIn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOptIn(Boolean optIn) {
        this.optIn = optIn;
    }

}
