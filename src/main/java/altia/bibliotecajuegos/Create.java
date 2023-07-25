package altia.bibliotecajuegos;

import entity.DesarrolladorEntity;
import entity.JuegoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/home")
public class Create {
    @GetMapping("/crear")
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        DesarrolladorEntity desarrollador = new DesarrolladorEntity("aa", 199);
        //session.save(desarrollador);
        session.persist(desarrollador);
        t.commit();
        System.out.println("Exito");

        sessionFactory.close();
    }
}
