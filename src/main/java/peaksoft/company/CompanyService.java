package peaksoft.company;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class CompanyService {
    public Long create(Company company){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created company");
        return company.getId();
    }
    public Company getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.getTransaction().commit();
        session.close();
        return company;
    }
    public List<Company> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Company> companies = session.createQuery("FROM Company").getResultList();
        session.beginTransaction().commit();
        session.close();
        return companies;
    }
    public void update(Long id, String name, String founder){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        company.setName(name);
        company.setFounder(founder);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session =HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.delete(company);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + company);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Company ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Company");
    }
}
