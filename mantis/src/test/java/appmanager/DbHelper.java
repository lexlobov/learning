package appmanager;

import Model.User;
import Model.Users;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DbHelper {


    private final SessionFactory sessionFactory;

    public DbHelper(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Transactional
    public List<User> users(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> result = session.createQuery("from User where enabled=1").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public Users usersSet() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> result = session.createQuery("from User where enabled=1").list();
        Users users = new Users(result);
        session.getTransaction().commit();
        session.close();
        return users;

    }
}
