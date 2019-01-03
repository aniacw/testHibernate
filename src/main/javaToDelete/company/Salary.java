package javaToDelete.company;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Salary")
@Table(name = "salary_mapping")
public class Salary implements Serializable {
    @Id
    @Column(unique = true, length = 5, nullable = false)
    private String paygrade;

    @Column
    private double salary_value;

    @OneToMany(mappedBy = "salary", fetch = FetchType.EAGER)
    //@JoinColumn(name = "paygrade")
    private List<Employee> assignedEmployees;

    public String getPaygrade() {
        return paygrade;
    }

    public void setPaygrade(String paygrade) {
        this.paygrade = paygrade;
    }

    public double getSalaryValue() {
        return salary_value;
    }

    public void setSalaryValue(double salary) {
        this.salary_value = salary;
    }

    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }

    public void setAssignedEmployees(List<Employee> assignedEmployees) {
        this.assignedEmployees = assignedEmployees;
    }

    public Salary(){}

    @Override
    public String toString() {
        return "Salary{" +
                "paygrade='" + paygrade + '\'' +
                ", salary=" + salary_value +
                ", assignedEmployees=" + assignedEmployees +
                '}';
    }
}
