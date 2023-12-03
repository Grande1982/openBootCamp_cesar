/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package BaseDatosIdiomas_v2;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cesar
 */
public class ProyectoIdioma {

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        //creamos el gestor de persistencia
        emf = Persistence.createEntityManagerFactory("PersistenceUnit_Idiomas");

        //consultamos las tablas de la BBDD
        System.out.println("TABLA PROFESORES INICIALMENTE");
        System.out.println("=============================");
        verProfes();
        System.out.println("TABLA TUTORIAS INICIALMENTE");
        System.out.println("=============================");
        verTutorias();

        //3.A Realiza una inserción sobre la tabla tutorias
        insertarTutorias();
        System.out.println("TABLA PROFESORES TRAS INSERCCION");
        System.out.println("=============================");
        verProfes();
        System.out.println("TABLA TUTORIAS TRAS INSERCCION");
        System.out.println("=============================");
        verTutorias();

        //3.B Realiza un borrado sobre la tabla tutorias
        borrarTutorias();
        System.out.println("TABLA PROFESORES TRAS BORRADO");
        System.out.println("=============================");
        verProfes();
        System.out.println("TABLA TUTORIAS TRAS BORRADO");
        System.out.println("=============================");
        verTutorias();

        //4.Obtener un listado sobre las tablas profesores y tutorias que visualice codProfe, nombre, apellido, departamento, diaSemana y horaTutoria
        System.out.println("TABLA LISTADO");
        System.out.println("=============================");
        obtenerListado();
    }

    /**
     *
     * metodo para Obtener un listado sobre las tablas profesores y tutorias que
     * visualice codProfe, nombre, apellido, departamento, diaSemana y
     * horaTutoria.
     */
    private static void obtenerListado() {

        manager = emf.createEntityManager();
        //inicio transaccion
        manager.getTransaction().begin();

        // no existe join hacer pojos
        /*String query = "SELECT p.codProfe, p.nombre, p.apellido, p.departamento, t.diaSemana, t.horaTutoria from Profesores p inner join  Tutorias t on p.codProfe = t.profesor";
        List<Object[]> results = manager.createQuery(query).getResultList();

        for (Object[] p: results) {
            System.out.println(p[0] + " - "+p[1] + " - "+p[2] + " - "+p[3] + " - "+p[4] + " - "+p[5]);
        }*/
        //seria asi con los pojos
        //Recojo todos los registros de TUTORIAS como objetos
        //List<Tutorias> listaTutorias = manager.createQuery("SELECT * FROM Tutorias t").getResultList();

        List<Tutorias> listaTutorias = manager.createNamedQuery("Tutorias.findAll").getResultList();
        //Recorro la lista imprimiendo la información requerida
        for (Tutorias t : listaTutorias) {
            Profesores prof = t.getProfesor();
            System.out.println(
                    "codProfe: " + prof.getCodProfe()
                    + " nombre: " + prof.getNombre()
                    + " apellido: " + prof.getApellido()
                    + " departamento: " + prof.getDepartamento()
                    + " diaSemana: " + t.getDiaSemana()
                    + " horaTutorias: " + t.getHoraTutoria());
        }

        //teminamos la transaccion
        manager.getTransaction().commit();
        //cerramos
        manager.close();
    }

    /**
     *
     * metodo para insertar datos en la base de datos
     */
    @SuppressWarnings("empty-statement")
    private static void insertarTutorias() {

        manager = emf.createEntityManager();
        //inicio transaccion
        manager.getTransaction().begin();

        //creamos nuevo profesor
        BigDecimal big;
        big = new BigDecimal(1700);

        Profesores profe100 = new Profesores("P213", "Sara", "Grande", "Direccion", big, "Directora");
        //guardamos profesor
        manager.persist(profe100);
        //creamos nuevo tutoria
        Date date1 = null;
        String stringDate = "23:37:50";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        try {
            date1 = formatter.parse(stringDate);
        } catch (ParseException ex) {
            System.out.println("Error en pasar la hora");
        }

        manager.persist(new Tutorias("0500", "Cocina", "Martes", date1, profe100));

        //teminamos la transaccion
        manager.getTransaction().commit();
        //cerramos
        manager.close();

    }

    /**
     *
     * metodo para leer datos de la tabla profesores
     */
    private static void verProfes() {

        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Profesores> profes = (List<Profesores>) manager.createQuery("from Profesores").getResultList();
        profes.size();
        for (Profesores p : profes) {
            System.out.println(p);

        }
        manager.getTransaction().commit();
        manager.close();

    }

    /**
     *
     * metodo para leer datos de la tabla tutorias
     */
    private static void verTutorias() {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        List<Tutorias> tutos = (List<Tutorias>) manager.createQuery("from Tutorias").getResultList();
        tutos.size();
        for (Tutorias t : tutos) {
            System.out.println(t);

        }
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     *
     * metodo para borrar datos de la tabla tutorias
     */
    private static void borrarTutorias() {

        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Tutorias tutoBorra = manager.find(Tutorias.class, "0001");
        manager.remove(tutoBorra);
        manager.getTransaction().commit();
        manager.close();
    }

    //metodo para buscar. no lo pide en la tarea pero lo hice de cara al examen por si tengo que buscar
    //en alguna consulta
    private static void buscarProfesor() {

        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Profesores yo = manager.find(Profesores.class, "100");
        System.out.println(yo.getNombre());
        System.out.println(yo.getApellido());
        manager.getTransaction().commit();
        manager.close();
    }
}
