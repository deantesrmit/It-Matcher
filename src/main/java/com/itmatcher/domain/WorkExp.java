package com.itmatcher.domain;


/**
 * WorkExp Class - A class that represents work experience for freelancers
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
public class WorkExp {
    int id;
    String value;

    /**Gets the ID of the Work Experience
     * @return an int containing the ID of the Work Experience level */
    public int getId() {

        return id;
    }

    /**Sets the ID of the Work Experience level
     * @param id an int containing a work experience level*/
    public void setId(int id) {

        this.id = id;
    }

    /**Gets the value of the Work Experience
     * @return a string containing the value of the Work Experience level */
    public String getValue() {

        return value;
    }

    /**Sets the value of the Work Experience level
     * @param value a string containing a value for work experience level*/
    public void setValue(String value) {
        this.value = value;
    }
}
