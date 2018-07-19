package com.xm;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "mydb")
public class UsersEntity {
    private int userLogin;
    private String userFirstname;
    private String userLastname;

    @Id
    @Column(name = "user_login", nullable = false)
    public int getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(int userLogin) {
        this.userLogin = userLogin;
    }

    @Basic
    @Column(name = "user_firstname", nullable = false, length = 128)
    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    @Basic
    @Column(name = "user_lastname", nullable = false, length = 128)
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return userLogin == that.userLogin &&
                Objects.equals(userFirstname, that.userFirstname) &&
                Objects.equals(userLastname, that.userLastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userLogin, userFirstname, userLastname);
    }

    @Override
    public String toString() {
        return "Login: " + userLogin + " First name: " + userFirstname + " Lasst name: " + userLastname;
    }
}
