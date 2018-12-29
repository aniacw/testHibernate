package MainConsole;

import company.Employee;
import factory.Factory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateAnnotationMain {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setEmail("jack.white@gmail.com");
        e.setId(12);
        e.setName("Jack");
        e.setSurname("White");
        e.setPaygrade("aaabb");

        SessionFactory sessionFactory = Factory.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(e);

        session.getTransaction().commit();

        sessionFactory.close();
    }
}
