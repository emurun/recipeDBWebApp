package com.example.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StringObject {

    @JsonProperty
    public String data;

    public StringObject() {

    }

    public String getString() {
        return data;
    }

    public void setString(String data) {
        this.data = data;
    }
}
