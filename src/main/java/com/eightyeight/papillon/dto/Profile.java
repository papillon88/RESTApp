package com.eightyeight.papillon.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by papillon on 4/10/2017.
 */
@XmlRootElement
public class Profile {

    private long id;
    private String lastName;
    private String firstName;
    private String profileName;
    private Date created;

    public Profile(){}

    public Profile(long id, String lastName, String firstName, String profileName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.profileName = profileName;
        this.created = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
