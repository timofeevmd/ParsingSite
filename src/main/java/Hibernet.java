import objects.ObjectTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Hibernet {

    private SessionFactory sessionFactory;

    public void initDataBase(){
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(ObjectTable.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }

    public void addData(List<ObjectTable> table){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        table.forEach(session::save);
        session.getTransaction().commit();
        session.close();
    }

    public List<ObjectTable> getData(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM ObjectTable", ObjectTable.class);
        List<ObjectTable> list = (List<ObjectTable>)query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }
}
