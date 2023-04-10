package peaksoft.animal;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;
import java.util.Queue;

public class AnimalService {
    public Long create(Animal animal) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(animal);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created animal");
        return animal.getId();
    }

    public Animal getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        session.getTransaction().commit();
        session.close();
        return animal;
    }

    public List<Animal> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Animal> animals = session.createQuery("FROM Animal").getResultList();
        session.getTransaction().commit();
        session.close();
        return animals;
    }

    public void update(Long id, String name, String color, int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        animal.setName(name);
        animal.setColor(color);
        animal.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        session.delete(animal);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + animal);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Animal");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Animal");
    }
}
