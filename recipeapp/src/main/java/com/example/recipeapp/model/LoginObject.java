package com.example.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginObject {
    @JsonProperty
    public String email;

    @JsonProperty
    public String password;

    public LoginObject() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
