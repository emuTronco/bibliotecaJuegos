import entity.DesarrolladorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class CRUD {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();
    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        String nombreTabla;

        do {
            System.out.println("Elige una de las siguientes operaciones:\n.-1 Crear registro" +
                    "\n.-2 Leer registro\n.-3 Actualizar registro\n.-4 Borrar registro\n.-5 Salir");
            opcion = Integer.parseInt(sc.nextLine());
            System.out.print("Introduce el nombre de la tabla donde quieres realizar la operación: ");
            nombreTabla = sc.nextLine();
            
            switch (opcion) {
                case 1:
                    crearRegistro(nombreTabla);
                    break;
                case 2:
                    System.out.print("Introduce el ID del registro que quieres leer: ");
                    leerRegistro(nombreTabla, Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    actualizarRegistro(nombreTabla);
                    break;
                case 4:
                    borrarRegistro(nombreTabla);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción incorrecta, elige una opción de nuevo.");
                    
            }
            
        } while (opcion != 5);



    }

    private static void borrarRegistro(String nombreTabla) {
    }

    private static void actualizarRegistro(String nombreTabla) {
    }

    private static void leerRegistro(String nombreTabla, int id) {
    }

    private static void crearRegistro(String nombreTabla) {
        try {
            transaction.begin();

            DesarrolladorEntity desarrollador1 = new DesarrolladorEntity();
            desarrollador1.setIdDesarrollador(50);
            desarrollador1.setNombre("aa");
            desarrollador1.setNumJuegos(2);
            entityManager.persist(desarrollador1);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}
