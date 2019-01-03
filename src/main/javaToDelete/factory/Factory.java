package javaToDelete.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Factory {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernateAnnotation.cfg.xml").build();
            Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
            sessionFactory =meta.getSessionFactoryBuilder().build();
            //sessionFactory =
//            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(Employee.class);//dlaczego bez tego nie dziala?
//            configuration.configure("hibernateAnnotation.cfg.xml");
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionAnnotationFactory();
        return sessionFactory;
    }
}
