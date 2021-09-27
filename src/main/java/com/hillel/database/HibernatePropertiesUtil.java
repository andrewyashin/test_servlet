package com.hillel.database;

import com.hillel.entity.Customer;
import com.hillel.entity.House;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernatePropertiesUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(House.class);
            return configuration
                    .buildSessionFactory(serviceRegistry);
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in hibernate util");
        }
    }
}
