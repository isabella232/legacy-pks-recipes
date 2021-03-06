package com.pivotalservices.sample.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
        @NamedQuery(name = "user.list", query = "select u from User u"),
        @NamedQuery(name = "user.find.by.email", query = "select u from User u where u.email=:email")
})
public class User extends Model {

    @NotNull
    @Size(min = 3, max = 15)
    private String fullname;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;

    @NotNull
    @Pattern(regexp = ".+@.+\\.[a-z]+")
    private String email;

    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
