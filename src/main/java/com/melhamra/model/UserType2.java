package com.melhamra.model;


import javax.persistence.Entity;

@Entity
public class UserType2 extends User{

    private String type2Value;

    public String getType2Value() {
        return type2Value;
    }

    public void setType2Value(String type2Value) {
        this.type2Value = type2Value;
    }
}
