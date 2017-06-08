package com.codecool.bank.model;

public abstract class Details {
    Integer id;
    String name;
    String description;

    Details(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

}
