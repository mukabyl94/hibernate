package peaksoft.employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class EmployeeService {
    public Long create(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        return employee.getId();
    }
    public Employee getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        session.close();
        return employee;
    }
    public List<Employee> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee ").getResultList();
        session.getTransaction().commit();
        session.close();
        return employees;
    }
    public void update(Long id, String firstname, String lastname, int age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + employee);
    }
    public void deleteAll (){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Employee ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all dates in Employee");
    }
}
