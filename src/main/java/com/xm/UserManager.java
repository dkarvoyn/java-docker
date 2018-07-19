package com.xm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserManager {

    private static SessionFactory sessionFactory;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static UserManager singleton = null;

    public static UserManager getInstance() {
        if (singleton == null) {
            singleton = new UserManager();
            setup();
            System.out.println("Created UserManager");
        }
        return singleton;
    }

    public static void destroyInstance() {
        if (singleton != null) {
            exit();
            singleton = null;
        }
    }

    private static void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        //try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        //} catch (Exception ex) {
          //  StandardServiceRegistryBuilder.destroy(registry);
          //  System.out.println(">>>>>>>>>>>>> Error in setup");
        //}
    }

    private static void exit() {
        sessionFactory.close();
    }

    public UsersEntity getUser(int login) {
        Session session = sessionFactory.openSession();
        UsersEntity user = session.get(UsersEntity.class, login);
        log.info("User retrieved: " + user);
        return user;
    }
}
