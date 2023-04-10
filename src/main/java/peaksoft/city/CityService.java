package peaksoft.city;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.animal.Animal;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class CityService {
    public Long create(City city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created city");
        return city.getId();
    }

    public City getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city = session.get(City.class, id);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public List<City> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<City> cities = session.createQuery("FROM City").getResultList();
        session.getTransaction().commit();
        session.close();
        return cities;
    }

    public void update(Long id, String name, Long population) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city = session.get(City.class, id);
        city.setName(name);
        city.setPopulation(population);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city = session.get(City.class, id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + city);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM City");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in City");
    }
}
