package peaksoft.customer;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class CustomerService {
    public Long create(Customer customer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        return customer.getId();
    }
    public Customer getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.getTransaction().commit();
        session.close();
        return customer;
    }
    public List<Customer> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("FROM Customer ").getResultList();
        session.getTransaction().commit();
        session.close();
        return customers;
    }
    public void update(Long id, String firstName, String lastName, int age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session =HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + customer);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Customer ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Customer");
    }
}
