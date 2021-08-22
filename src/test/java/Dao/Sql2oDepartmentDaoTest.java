package Dao;

import Models.Department;
import Models.Users;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oDepartmentDaoTest {
    private static Sql2oDepartmentDao departmentDao;
    private static Sql2oUsersDao usersDao;
    private Connection con;

    @BeforeEach
    void setUp() throws Exception{
        String connectionString = "jdbc:postgresql://localhost5432:/news_java";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "myPassword");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        con = sql2o.open();
    }

    @AfterAll
    static void tearDown() throws Exception{
        System.out.println("database clearance");
        departmentDao.clearAllDepartments();
    }

    @AfterEach
    void shutDown() throws Exception{
        con.close();
        System.out.println("closed connection");
    }

    @Test
    void getsAllDepartmentsStringInstantiatesCorrectly() {
        Department testDepartment = setupDepartment();
        Department testDepartmentA = setupDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartmentA);
        assertNotEquals(2, departmentDao.getAll().size());
    }

    @Test
    void getAllDepartmentsById() {
        Department testDepartment = setupDepartment();
        int departmentId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertNotEquals(departmentId, testDepartment.getId());
    }

    @Test
    void deletesByIdTheDepartment() {
        Department testDepartment = setupDepartment();
        departmentDao.add(testDepartment);
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    void removeAllDepartments() {
        Department testDepartment = setupDepartment();
        Department testDepartmentA = setupDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartmentA);
        int getSize = departmentDao.getAll().size();
        departmentDao.clearAllDepartments();
        assertTrue(getSize > 0 && getSize > departmentDao.getAll().size());
    }

    @Test
    void departmentInstantiatesWithUserCorrectly() {
        Users testUser = setupUser();
        usersDao.add(testUser);
        Users testUserA = new Users("Njeri", "Human Resource", "Human Resource Management");
        usersDao.add(testUserA);
        Department testDepartment = setupDepartment();
        departmentDao.add(testDepartment);
    }

   public Department setupDepartment() {
        return new Department("Sports", "Get best entertainment", "Brian, Peter");
   }

   public Users setupUser() {
        return new Users("Joy", "Tech lead", "Information Technology");
   }
}