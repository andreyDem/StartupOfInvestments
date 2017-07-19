package ua.com.startup.investments.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The class implements a set of standard methods for working
 * with entity of the Orders.
 *
 * @author Demchuck Andrey
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Display the name of the user
     */
    @Column(name = "name")
    private String name;

    /**
     * Display a surname of the user.
     */
    @Column(name = "surname")
    private String surname;

    /**
     * TDisplay an adress of the user
     */
    @Column(name = "address")
    private String address;

    /**
     * Display the phone number of the user
     */
    @Column(name = "phone")
    private Integer phone;

    /**
     * Display the identifier for each user role.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

    /**
     * The default constructor of entities orders.
     */
    public User() {
    }

    /**
     * Constructor
     * @param id an unique identifier for user.
     * @param name display the name of user.
     * @param surname display the surname of user
     * @param address display the address of user
     * @param phone display phone number of user
     * @param role display role of user
     */
    public User(Integer id, String name, String surname, String address, Integer phone, Roles role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public User(Integer id, String name, String surname, Integer phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor without role
     * @param id an unique identifier for user.
     * @param name display the name of user.
     * @param surname display the surname of user
     * @param address display the address of user
     * @param phone display phone number of user
     */
    public User(Integer id, String name, String surname, String address, Integer phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Getters and setters methods by all fields of user.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param users The reference object with which to compare.
     * @return Returns true if this user is the same as the object
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object users) {
        if (this == users) return true;
        if (!(users instanceof User)) return false;

        User user = (User) users;

        if (getId() != user.getId()) return false;
        if (getPhone() != user.getPhone()) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getSurname().equals(user.getSurname())) return false;
        if (!getAddress().equals(user.getAddress())) return false;
        return getRole() == user.getRole();
    }

    /**
     * Check a hash code value for the user.
     *
     * @return A hash code value for this user.
     */
    @Override
    public int hashCode() {
        int result = (Integer) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getPhone();
        result = 31 * result + getRole().hashCode();
        return result;
    }

    /**
     * Returns a string representation of the user.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", role=" + role +
                '}';
    }
}
