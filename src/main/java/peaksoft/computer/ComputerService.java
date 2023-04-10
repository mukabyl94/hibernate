package peaksoft.computer;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class ComputerService {
    public Long creat(Computer computer){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(computer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created computer");
        return computer.getId();
    }
    public Computer getById (Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Computer computer = session.get(Computer.class, id);
        session.getTransaction().commit();
        session.close();
        return computer;
    }
    public List<Computer> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Computer> computers = session.createQuery("FROM Computer").getResultList();
        session.getTransaction().commit();
        session.close();
        return computers;
    }
    public void update(Long id, String name, String model){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Computer computer = session.get(Computer.class, id);
        computer.setName(name);
        computer.setModel(model);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated ");
    }
    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Computer computer = session.get(Computer.class, id);
        session.delete(computer);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + computer);
    }
    public void deletedAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Computer ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Computer");
    }
}
