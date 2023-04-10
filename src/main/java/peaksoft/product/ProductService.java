package peaksoft.product;

import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.customer.Customer;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class ProductService {
    public Long create(Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        return product.getId();
    }
    public Product getById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        session.close();
        return product;
    }
    public List<Product> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("FROM Product ").getResultList();
        session.getTransaction().commit();
        session.close();
        return products;
    }
    public void update(Long id, String name, String brand, int price){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setName(name);
        product.setBrand(brand);
        product.setPrice(price);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated");
    }
    public void delete(Long id){
        Session session =HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + product);
    }
    public void deleteAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Product ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Product");
    }
}
