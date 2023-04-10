package peaksoft.util;

import org.hibernate.SessionFactory;

import java.util.Properties;

public class HibernateConfig {

    public static Properties properties(){
        Properties prop= new Properties();
        prop.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresSQL");
        prop.setProperty("hibernate.connection.username", "admin");
        prop.setProperty("hibernate.connection.password", "admin");
        prop.setProperty("hibernate.hbm2ddl.auto","update");
        prop.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        prop.setProperty("hibernate.show_sql","true");
        return prop;
    }
}
