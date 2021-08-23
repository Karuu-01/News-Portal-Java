package Dao;

import Models.Department;
import Models.Users;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oUsersDaoTest {
    private static Sql2oUsersDao usersDao;
    private static Sql2oDepartmentDao departmentDao;
    private static Connection con;

    @BeforeEach
    void setUp() throws Exception{
        String connectionString = "jdbc:postgresql://localhost:5432/news_java";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "myPassword");
        usersDao = new Sql2oUsersDao(sql2o);
        con = sql2o.open();
    }

    @AfterEach
    void tearDown() throws Exception{
        System.out.println("clear database");
        usersDao.clearAllUsers();
    }

    @AfterAll
    static void shutDown() throws Exception{
        con.close();
        System.out.println("closed connection");
    }

    @Test
    void usersIdCorrectly() {
        Users testUser = setupUser();
        int usersId = testUser.getId();
        usersDao.add(testUser);
        assertNotEquals(usersId, testUser.getId());
    }

    @Test
    void getAllUsers() {
        Users testUser = setupUser();
        Users testUser1 = setupUser();
        Users testUser2 = setupUser();
        usersDao.add(testUser);
        usersDao.add(testUser1);
        usersDao.add(testUser2);
        assertNotEquals(0, usersDao.getAll().size());
    }

//    @Test
//    void addUserToDepartment() {
//        Department testDepartment = setupDepartment();
//        departmentDao.add(testDepartment);
//        Users testUser = setupUser();
//        usersDao.add(testUser);
//        usersDao.addUserToDepartment(testUser, testDepartment);
//        assertEquals(2, departmentDao.getAllDepartmentUsers(testDepartment.getId()));
//     }

    @Test
    void deleteById() throws Exception{
        Users testUser = setupUser();
        usersDao.add(testUser);
        usersDao.deleteById(testUser.getId());
        assertEquals(0, usersDao.getAll().size());
    }

    @Test
    void clearAllUsersFromDepartments() {
        Users testUser = setupUser();
        Users testUser1 = setupUser();
        usersDao.add(testUser);
        usersDao.add(testUser1);
        int userSize = usersDao.getAll().size();
        usersDao.clearAllUsers();
        assertTrue(userSize > 0 && userSize > usersDao.getAll().size());
    }

    public Users setupUser() {
        return new Users("Robb", "Human Resource", "Human Resource Management");
    }

    public Department setupDepartment(){
        return new Department("Technical", "Ensures data is well handled", "Brian, Ian");
    }
}