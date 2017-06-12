package ua.com.startup.investments.entities;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "solution")
    private String solution;
    @Column(name = "final_cost")
    private int finalCost;
    @Column(name = "assemble_cost")
    private int assembleCost;
    @Column(name = "owner")
    private String owner;
}
