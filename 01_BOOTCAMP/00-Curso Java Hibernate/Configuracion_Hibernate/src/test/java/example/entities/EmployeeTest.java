package example.entities;

import org.example.entities.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
                4000d,
                true,
                LocalDate.of(1950,12,25),
                LocalDateTime.now());



        session.save(employee1);
        session.close();
        sessionFactory.close();
        HibernateUtil.shutdown();

    }

    @Test
    void insertData(){


    }

}
