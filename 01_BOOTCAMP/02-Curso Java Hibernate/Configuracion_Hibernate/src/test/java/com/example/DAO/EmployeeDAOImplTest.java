package com.example.DAO;

import com.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOImplTest {
    EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAllCesar() {

        List<Employee> employees = dao.findAll();
        System.out.println(employees);
    }

    @Test
    void testFindAllCesar() {
        List<Employee> employees = dao.findAllCesar();
        System.out.println(employees);
    }
}