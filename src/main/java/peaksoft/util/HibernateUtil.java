package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Car;
import peaksoft.entity.Student;

public class HibernateUtil {

    private static SessionFactory buildSessionFactory(){
        SessionFactory sessionFactory = null;
        try{
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
//                    .addAnnotatedClass(Student.class)
//                    .addAnnotatedClass(Car.class)
                    .buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        return buildSessionFactory();
    }
}
