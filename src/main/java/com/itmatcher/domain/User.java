package com.itmatcher.domain;

import com.itmatcher.type.AccountType;

/**
 * User Class - represents a User
 *
 * @author dean, bede, melissa, john, mark and stephen
 * @version 1.0
 *
 */
public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String salt;
    private String accountType;

    /**Gets the ID of the User
     * @return an int containing the ID of the User */
    public int getId() {
        return id;
    }

    /**Sets the ID of the User
     * @param id an int containing an ID for a user*/
    public void setId(int id) {
        this.id = id;
    }

    /**Gets the first name of the User
     * @return a string containing the first name of the User */
    public String getFirstName() {
        return firstName;
    }

    /**Sets the first name of the User
     * @param firstName a string containing the first name of the user*/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**Gets the last name of the User
     * @return a string containing the last name of the User */
    public String getLastName() {
        return lastName;
    }

    /**Sets the last name of the User
     * @param lastName a string containing a last name for a user*/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**Gets the email of the User
     * @return a string containing the email of the User */
    public String getEmail() {
        return email;
    }

    /**Sets the email of the User
     * @param email a string containing an email for a user*/
    public void setEmail(String email) {
        this.email = email;
    }

    /**Gets the password of the User
     * @return a string containing the password of the User */
    public String getPassword() {
        return password;
    }

    /**Sets the password of the User
     * @param password a string containg the password of a user*/
    public void setPassword(String password) {
        this.password = password;
    }

    /**Gets the salt for the password of the User
     * @return a string containing the salt of the password of the User */
    public String getSalt() {
        return salt;
    }

    /**Sets the salt of the User
     * @param salt a string containing the salt of a user*/
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**Gets the username of the User
     * @return a string containing the username of the User */
    public String getUsername() {
        return username;
    }

    /**Sets the username of the User
     * @param username a string containing the username of a user*/
    public void setUsername(String username) {
        this.username = username;
    }

    /**Gets the account type of the User
     * @return a string containing the account type of the User */
    public String getAccountType() {
        return accountType;
    }

    /**Sets the account type of the User
     * @param accountType a string containing the acount type of a user*/
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
