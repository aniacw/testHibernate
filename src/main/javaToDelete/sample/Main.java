package javaToDelete.sample;

import javaToDelete.company.Salary;
import javaToDelete.factory.Factory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
       //launch(args);
        SessionFactory sessionFactory =  Factory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Salary");
        List<Salary> salaries = query.getResultList();
        session.getTransaction().commit();
        session.close();
        for (Salary s : salaries){
            System.out.println(s);
        }
    }
}
