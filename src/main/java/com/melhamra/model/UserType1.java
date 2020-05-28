package com.melhamra.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserType1 extends User{

    private String type1Value;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getType1Value() {
        return type1Value;
    }

    public void setType1Value(String type1Value) {
        this.type1Value = type1Value;
    }
}
