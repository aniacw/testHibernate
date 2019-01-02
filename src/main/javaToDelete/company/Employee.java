package javaToDelete.company;


import javax.persistence.*;

@Entity
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "surname")})
@NamedQueries(
        {@NamedQuery(name = Employee.GET_EMAIL_BY_SURNAME, query = Employee.GET_EMAIL_BY_SURNAME_QUERY)}
)
public class Employee {

    static final String GET_EMAIL_BY_SURNAME_QUERY = "from Employee e where e.surname = :surname";
    public static final String GET_EMAIL_BY_SURNAME = "GET_EMAIL_BY_SURNAME";


    @Column(name = "emp_name", length = 20, nullable = false)
    private String name;


    @Column(name = "surname", length = 20, nullable = false)
    private String surname;

    @Column(name = "email", length = 25, nullable = false)
    private String email;

    @Column(name = "id", unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "paygrade", length = 5)
    private String paygrade;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaygrade() {
        return paygrade;
    }

    public void setPaygrade(String paygrade) {
        this.paygrade = paygrade;
    }


}
