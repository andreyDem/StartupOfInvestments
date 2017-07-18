package ua.com.startup.investments.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The class implements a set of standard methods for working
 * with entity of the Project.
 *
 * @author Aleksey Girya
 */
@Entity
@Table(name = "projects")
public class Project implements Serializable {

    /**
     * Display the unique identifier for each project.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
    private Integer finalCost;

    /**
     * Display assemble cost of the project
     */
    @Column(name = "assemble_cost")
    private Integer assembleCost;

    /**
     * Display the owner of the project
     */
    @Column(name = "id_user")
    private Integer idUser;

    /**
     * The default constructor of entities project.
     */
    public Project() {
    }

    /**
     * Constructor
     *
     * @param id           a unique identifier for project.
     * @param name         of the project
     * @param solution     contains description of the project
     * @param finalCost    display an information about final cost of the project
     * @param assembleCost display an information about assemble cost of the project
     * @param idUser       display an information about owner of the project
     */
    public Project(Integer id, String name, String solution, Integer finalCost, Integer assembleCost, Integer idUser) {
        this.name = name;
        this.solution = solution;
        this.finalCost = finalCost;
        this.assembleCost = assembleCost;
        this.idUser = idUser;
    }

    /**
     * Getters and setters methods by all fields of project.
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

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Integer finalCost) {
        this.finalCost = finalCost;
    }

    public Integer getAssembleCost() {
        return assembleCost;
    }

    public void setAssembleCost(Integer assembleCost) {
        this.assembleCost = assembleCost;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return Returns true if this user is the same as the object
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (getId() != project.getId()) return false;
        if (getFinalCost() != project.getFinalCost()) return false;
        if (getAssembleCost() != project.getAssembleCost()) return false;
        if (!getName().equals(project.getName())) return false;
        if (!getSolution().equals(project.getSolution())) return false;
        return getIdUser().equals(project.getIdUser());
    }

    /**
     * Check a hash code value for the project.
     *
     * @return A hash code value for this project.
     */
    @Override
    public int hashCode() {
        int result = (int) getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getSolution().hashCode();
        result = 31 * result + getFinalCost();
        result = 31 * result + getAssembleCost();
        result = 31 * result + getIdUser().hashCode();
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
                ", owner='" + idUser + '\'' +
                '}';
    }
}
