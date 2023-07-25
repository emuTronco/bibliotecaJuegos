package altia.bibliotecajuegos;

import entity.DesarrolladorEntity;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    public static SessionFactory provideSessionFactory() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml").addAnnotatedClass(DesarrolladorEntity.class);
        return config.buildSessionFactory();
    }
}
