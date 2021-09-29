package com.hillel.database;

import com.hillel.entity.Customer;
import com.hillel.entity.House;
import com.hillel.entity.Passport;
import com.hillel.entity.Role;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateXMLUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }
        Configuration configure = new Configuration().configure();
        configure.addAnnotatedClass(Customer.class);
        configure.addAnnotatedClass(House.class);
        configure.addAnnotatedClass(Role.class);
        configure.addAnnotatedClass(Passport.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configure.getProperties());
        sessionFactory = configure.buildSessionFactory(builder.build());
        return sessionFactory;
    }
}
