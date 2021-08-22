package Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void GenerateTestThatInstantiatesWithAllInstances() {
        Department testDepartment = setupDepartment();
        assertTrue(testDepartment instanceof  Department);
    }

    @Test
    void GenerateStringThatInstantiatesWithNameCorrectly() {
        Department testDepartment = setupDepartment();
        assertEquals("Sports Department", testDepartment.getName());
    }

    @Test
    void GetDescriptionStringInstantiatesCorrectlyWithDescription() {
        Department testDepartment = setupDepartment();
        assertEquals("Get the best news about sports worldwide", testDepartment.getDescription());
    }

    @Test
    void GetIntegerOfEmployeesInDepartmentInstantiatesWithIntegerCorrectly() {
        Department testDepartment = setupDepartment();
        assertEquals(1, testDepartment.getEmployeeTag());
    }

    public Department setupDepartment() {
        return new Department("Sports Department", "Get the best news about sports worldwide", 1);
    }
}