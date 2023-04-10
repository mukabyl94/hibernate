package peaksoft.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.entity.Student;
import peaksoft.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public Long create(Student student){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction();
        session.close();
        System.out.println("Successfully created student");
        return student.getId();
    }
    public Student getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return  student;
    }
    public List<Student> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("FROM Student").getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }
    public void update(Long id, String firstname, String lastname, int age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        student.setFirstName(firstname);
        student.setLastName(lastname);
        student.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + student);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Student ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all dates in Student");
    }
}
