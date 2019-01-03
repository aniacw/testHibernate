package javaToDelete.sample;

import javaToDelete.company.Employee;
import javaToDelete.factory.Factory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Controller {

    @FXML
    TextField
            surnameEmailTextField,
            surnameSalaryTextField,
            paygradeTextField,
            deleteTextField,
            emailResultTextField,
            salaryResultTextField,
            addName,
            addSurname,
            addEmail,
            addPaygrade;

    @FXML
    Button
            emailButton,
            salaryButton,
            paygradeButton,
            deleteButton,
            addEmployeeButton;

    SessionFactory sessionFactory;

    Employee employee;


    public void initialize(){
        sessionFactory = Factory.getSessionFactory();
//        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernateAnnotation.cfg.xml").build();
//        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
//        sessionFactory=meta.getSessionFactoryBuilder().build();
        employee = new Employee();
    }

    public void onButtonEmailButtonClicked() {

 //      EntityManager entityManager = sessionFactory.createEntityManager();
//        Employee e = entityManager.find(Employee.class, )

//
//        String email = employee.getEmail();
//        emailResultTextField.setText(email);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
   //     Criteria criteria = session.createCriteria(Employee.class);
 //       Object surn = criteria.add(Restrictions.eq("surname", surnameEmailTextField.getText())).uniqueResult();

//        String inputSurname = surnameEmailTextField.getText();
//        Query query = entityManager.createQuery("select email from employees where surname = "+inputSurname);

        //Query query = session.createQuery("from Employee as e where e.surname = :surname");
        Query query = session.getNamedQuery(Employee.GET_EMAIL_BY_SURNAME);
        query.setParameter("surname", surnameEmailTextField.getText());
        List<Employee> employees = (List<Employee>)query.getResultList();
        if (employees.isEmpty()){
            emailResultTextField.setText("<empty>");
        }
        else{
            employee = employees.get(0);
            String email = employee.getEmail();
            emailResultTextField.setText(email);
            //session.getTransaction().commit();
            //sessionFactory.close();

        }
        session.getTransaction().commit();
        session.close();
    }

    public void onButtonAddEmployeeClicked() {
        employee.setEmail(addEmail.getText());
        employee.setName(addName.getText());
       // employee.setPaygrade(addPaygrade.getText());
        employee.setSurname(addSurname.getText());
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
