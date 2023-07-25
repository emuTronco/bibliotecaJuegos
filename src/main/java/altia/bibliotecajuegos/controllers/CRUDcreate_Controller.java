package altia.bibliotecajuegos.controllers;

import entity.JuegoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class CRUDcreate_Controller {

//    @Autowired
//    BibliotecaJuegosService bjService;
//
//    @GetMapping("/create")
//    public int crearJuego(@RequestBody JuegoEntity juego) {
//        bjService.saveOrUpdate(juego);
//        System.out.println("Creado");
//        return juego.getIdJuego();
//    }

//    @GetMapping("/create")
//    public String create() {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//        try {
//            transaction.begin();
//
//            DesarrolladorEntity desarrollador1 = new DesarrolladorEntity();
//            desarrollador1.setIdDesarrollador(50);
//            desarrollador1.setNombre("aa");
//            desarrollador1.setNumJuegos(2);
//            desarrollador1.setBeneficios(10000);
//            entityManager.persist(desarrollador1);
//
//            transaction.commit();
//
//        } catch (Exception e) {
//            System.out.println("Se ha producido un error: " + e.getMessage());
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//
//        } finally {
//            entityManager.close();
//            entityManagerFactory.close();
//            return "Entidad creada correctamente";
//        }
//    }
}
