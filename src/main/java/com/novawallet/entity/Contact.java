package com.novawallet.entity;

import static com.novawallet.app.Utils.capitalize;
import static com.novawallet.app.Utils.getInitial;

/**
 * The type Contact.
 */
public class Contact {
    private final int id;
    private String name;
    private String lastname;
    private String email;

    /**
     * Instantiates a new Contact.
     *
     * @param name     the name
     * @param lastname the lastname
     * @param email    the email
     */
    public Contact(int id, String name, String lastname, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets Fullname.
     *
     * @return the fullname
     */
    public String getFullname() {
        return STR."\{capitalize(name)} \{capitalize(lastname)}";
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
