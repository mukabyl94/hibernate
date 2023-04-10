package peaksoft.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.entity.Car;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class CarService {
    public Long create(Car car) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created car");
        return car.getId();
    }
    public Car getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }
    public List<Car> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Car> car = session.createQuery("FROM Car").getResultList();
        session.getTransaction().commit();
        session.close();
        return car;
    }
    public void update(Long id, String name, String color){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        car.setName(name);
        car.setColor(color);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + car);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Car");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Car");
    }
}
