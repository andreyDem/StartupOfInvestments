package ua.com.startup.investments.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The class implements a set of standard methods for working
 * with entity of the Project.
 *
 * @author Вадим
 */
@Entity
@Table(name = "projects")
public class Project implements Serializable{

    /**
     * Display the unique identifier for each project.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Display the name of the project
     */
    @Column(name = "name")
    private String name;

    /**
     * Display the description of the project
     */
    @Column(name = "solution")
    private String solution;

    /**
     * Display finak cost of the project
     */
    @Column(name = "final_cost")
    private int finalCost;

    /**
     * Display assemble cost of the project
     */
    @Column(name = "assemble_cost")
    private int assembleCost;

    /**
     * Display the owner of the project
     */
    @Column(name = "owner")
    private String owner;

    /**
     * The default constructor of entities project.
     */
    public Project() {
    }

    /**
     * Constructor
     * @param id a unique identifier for project.
     * @param name of the project
     * @param solution contains description of the project
     * @param finalCost display an information about final cost of the project
     * @param assembleCost display an information about assemble cost of the project
     * @param owner display an information about owner of the project
     */
    public Project(int id, String name, String solution, int finalCost, int assembleCost, String owner) {
        this.name = name;
        this.solution = solution;
        this.finalCost = finalCost;
        this.assembleCost = assembleCost;
        this.owner = owner;
    }
    /**
     * Getters and setters methods by all fields of project.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(int finalCost) {
        this.finalCost = finalCost;
    }

    public int getAssembleCost() {
        return assembleCost;
    }

    public void setAssembleCost(int assembleCost) {
        this.assembleCost = assembleCost;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param proj the reference object with which to compare.
     * @return Returns true if this user is the same as the object
     * argument, otherwise returns false.
     */

    @Override
    public boolean equals(Object proj) {
        if (this == proj) return true;
        if (!(proj instanceof Project)) return false;

        Project project = (Project) proj;

        if (getId() != project.getId()) return false;
        if (getFinalCost() != project.getFinalCost()) return false;
        if (getAssembleCost() != project.getAssembleCost()) return false;
        if (!getName().equals(project.getName())) return false;
        if (!getSolution().equals(project.getSolution())) return false;
        return getOwner().equals(project.getOwner());
    }

    /**
     * Check a hash code value for the project.
     *
     * @return A hash code value for this project.
     */
    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSolution().hashCode();
        result = 31 * result + getFinalCost();
        result = 31 * result + getAssembleCost();
        result = 31 * result + getOwner().hashCode();
        return result;
    }
    /**
     * Returns a string representation of the project.
     */
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", finalCost=" + finalCost +
                ", assembleCost=" + assembleCost +
                ", owner='" + owner + '\'' +
                '}';
    }
}
