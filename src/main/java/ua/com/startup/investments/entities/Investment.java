package ua.com.startup.investments.entities;

import javax.persistence.*;

@Entity
@Table(name = "investments")
public class Investment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "sum")
    private int sum;
}
