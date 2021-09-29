package com.hillel.database;

import com.hillel.entity.Customer;
import com.hillel.entity.House;
import com.hillel.entity.Passport;
import com.hillel.entity.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Passport.class);
            return configuration
                    .buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in hibernate util");
        }
    }
}
