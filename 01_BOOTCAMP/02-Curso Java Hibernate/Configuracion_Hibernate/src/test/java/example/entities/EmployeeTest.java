package example.entities;

import com.example.DAO.EmployeeDAO;
import com.example.DAO.EmployeeDAOImpl;
import com.example.entities.Employee;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeTest {




    @Test
    void createTableTest(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee(null,
                "cesar",
                "grande",
                "ex@gmail.com",
                32,
                (double) 4000.0,
                true,
                LocalDate.of(1950,12,25),
                LocalDateTime.now());


        //empezamos a transacion con bd
        session.beginTransaction();

        //guardamos los objetos
        session.save(employee1);

        //insertamos los cambio en la bd
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();

    }







}
