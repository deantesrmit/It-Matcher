package com.itmatcher.domain;

/**
 * Education Class - Represents the education level of a freelancer
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
public class Education {
    int id;
    String value;

    /**Gets the id of the education level */
    public int getId() {
        return id;
    }

    /**Sets the id of the education level */
    public void setId(int id) {
        this.id = id;
    }

    /**Gets the value of the education level */
    public String getValue() {
        return value;
    }

    /**Sets the value of the education level */
    public void setValue(String value) {
        this.value = value;
    }
}
