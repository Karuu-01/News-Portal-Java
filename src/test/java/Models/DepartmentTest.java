package Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void GenerateTestThatInstantiatesWithAllInstances() throws Exception{
        Department testDepartment = setupDepartment();
        assertTrue(testDepartment instanceof  Department);
    }

    @Test
    void GenerateStringThatInstantiatesWithNameCorrectly() throws Exception{
        Department testDepartment = setupDepartment();
        assertEquals("Sports Department", testDepartment.getName());
    }

    @Test
    void GetDescriptionStringInstantiatesCorrectlyWithDescription() throws Exception{
        Department testDepartment = setupDepartment();
        assertEquals("Get the best news about sports worldwide", testDepartment.getDescription());
    }

    @Test
    void GetStringOfEmployeesInDepartmentInstantiatesWithStringCorrectly() throws Exception{
        Department testDepartment = setupDepartment();
        assertEquals("Robb,Paul", testDepartment.getEmployee());
    }

    @Test
    void setNameDepartmentCorrectly() throws Exception{
        Department testDepartment = setupDepartment();
        testDepartment.setName("Reception Desk");
        assertNotEquals("Sports Department", testDepartment.getName());
    }

    @Test
    void setDepartmentsDescriptionCorrectly() throws Exception{
        Department testDepartment = setupDepartment();
        testDepartment.setDescription("Receives new clients");
        assertNotEquals("Get the best news about sports worldwide", testDepartment.getDescription());
    }

    @Test
    void setEmployeeNameCorrectly() throws Exception{
        Department testDepartment = setupDepartment();
        testDepartment.setEmployee("Bob,Emmanuel");
        assertNotEquals("Robb,Paul", testDepartment.getEmployee());
    }

    @Test
    void setDepartmentIdCorrectly() {
        Department testDepartment = setupDepartment();
        testDepartment.setId(2);
        assertNotEquals(1, testDepartment.getId());
    }

    public Department setupDepartment() {
        return new Department("Sports Department", "Get the best news about sports worldwide", "Robb,Paul");
    }
}