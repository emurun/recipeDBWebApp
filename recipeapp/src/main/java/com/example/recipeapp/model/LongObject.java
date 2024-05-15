package com.example.recipeapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LongObject {

    @JsonProperty
    public Long data;

    public LongObject() {
    }

    public Long getLong() {
        return data;
    }

    public void setLong(Long data) {
        this.data = data;
    }
}
