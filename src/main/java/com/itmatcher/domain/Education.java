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

    /**Gets the id of the education level
     * @return an int with the education ID */
    public int getId() {
        return id;
    }

    /**Sets the id of the education level
     * @param id An int containing the ID of the education level */
    public void setId(int id) {
        this.id = id;
    }

    /**Gets the value of the education level
     * @return a string containing the education level value */
    public String getValue() {
        return value;
    }

    /**Sets the value of the education level
     * @param value a string containing the education level value */
    public void setValue(String value) {
        this.value = value;
    }
}
