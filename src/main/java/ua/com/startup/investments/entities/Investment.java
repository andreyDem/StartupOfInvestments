package ua.com.startup.investments.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The class implements a set of standard methods for working
 * with entity of the Company.
 *
 * @author Girya Aleksey
 */

@Entity
@Table(name = "investments")
public class Investment implements Serializable {

    /**
     * Display an unique identifier for each investment.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * Display an amount of the investment
     */
    @Column(name = "sum")
    private Integer sum;

    /**
     * The default constructor of entities investments.
     */
    public Investment() {
    }

    public Investment(Integer sum) {
        this.sum = sum;
    }

    /**
     * Constructor
     *
     * @param id  a unique identifier for order.
     * @param sum display general amount of investment.
     */
    public Investment(Integer id, Integer sum) {
        this.id = id;
        this.sum = sum;
    }

    /**
     * Getters and setters methods by all fields of investment.
     */
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param investment the reference object with which to compare.
     * @return Returns true if this user is the same as the object
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object investment) {
        if (this == investment) return true;
        if (!(investment instanceof Investment)) return false;

        Investment that = (Investment) investment;

        if (getId() != that.getId()) return false;
        return getSum() == that.getSum();
    }

    /**
     * Check a hash code value for the investment.
     *
     * @return A hash code value for this user.
     */
    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getSum();
        return result;
    }

    /**
     * Returns a string representation of the investment.
     */
    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
