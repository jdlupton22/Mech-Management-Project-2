package entities;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;

    private String firstname;

    private String lastname;
    private Boolean isPilot;
    private Boolean isAdmin;

    public User() {
//        super();
    }
    public User(int id, String username, String password, String firstname, String lastname, boolean isPilot,
                boolean isAdmin) {
//        super();
        this.id = id;
        this.username = username;
        this.password =  password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isPilot = isPilot;
        this.isAdmin = isAdmin;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Boolean getIsPilot() {
        return isPilot;
    }
    public void setIsPilot(Boolean isPilot) {
        this.isPilot = isPilot;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getFirstname(), getLastname(), getIsPilot(),
                getIsAdmin());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", firstname=" + firstname +
                ", lastname=" + lastname +
                ", isPilot=" + isPilot +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
