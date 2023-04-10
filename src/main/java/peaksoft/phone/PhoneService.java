package peaksoft.phone;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class PhoneService {
    public Long creat(Phone phone){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
        session.close();
        return phone.getId();
    }
    public Phone getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        session.getTransaction().commit();
        session.close();
        return phone;
    }
    public List<Phone> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List phones = session.createQuery("FROM Phone ").getResultList();
        session.getTransaction().commit();
        session.close();
        return phones;
    }
    public void update(Long id, String name, String model, String color){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        phone.setName(name);
        phone.setModel(model);
        phone.setColor(color);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + phone);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Phone ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Phone");
    }
}
