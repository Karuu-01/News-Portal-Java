package Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void GetAllInstances() {
        Users testUsers = setupUser();
        assertTrue(testUsers instanceof Users );
    }

    @Test
    void GetNameInstantiatesWithString_name() throws Exception{
        Users testUser = setupUser();
        assertEquals("Manager", testUser.getName());
    }

    @Test
    void GetRoleInstantiatesWithString_roles() throws Exception{
        Users testUser = setupUser();
        assertEquals("Ensure operations are conducted properly", testUser.getRoles());
    }

    @Test
    void GetDepartmentsInstantiatesWithDepartmentAssociatedWith_department() {
        Users testUser = setupUser();
        assertEquals("Communications department", testUser.getDepartments());
    }

    @Test
    void setUseridCorrectly() {
        Users testUser = setupUser();
        testUser.setId(2);
        assertNotEquals(1, testUser.getId());
    }

    @Test
    void setsNameCorrectly() {
        Users testUser = setupUser();
        testUser.setName("Assistant Director");
        assertNotEquals("Manager", testUser.getName());
    }

    @Test
    void setDescriptionCorrectly() {
        Users testUser = setupUser();
        testUser.setDepartments("technical team");
        assertNotEquals("Communication department", testUser.getDepartments());
    }

    @Test
    void setRolesCorrectly() {
        Users testUser = setupUser();
        testUser.setRoles("ensure all communications channels work correctly");
        assertNotEquals("Ensure operations are conducted properly", testUser.getRoles());
    }

    public Users  setupUser() {
        return new Users("Manager", "Ensure operations are conducted properly", "Communications department");
    }

}