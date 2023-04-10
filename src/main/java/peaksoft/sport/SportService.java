package peaksoft.sport;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.product.Product;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class SportService {
    public Long create(Sport sport){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(sport);
        session.getTransaction().commit();
        session.close();
        return sport.getId();
    }
    public Sport getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sport sport = session.get(Sport.class, id);
        session.getTransaction().commit();
        session.close();
        return sport;
    }
    public List<Sport> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Sport> sports = session.createQuery("FROM Sport ").getResultList();
        session.getTransaction().commit();
        session.close();
        return sports;
    }
    public void update(Long id, String name, int contract){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sport sport = session.get(Sport.class, id);
        sport.setName(name);
        sport.setContract(contract);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session =HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Sport sport = session.get(Sport.class, id);
        session.delete(sport);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + sport);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Sport ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Sport");
    }
}
