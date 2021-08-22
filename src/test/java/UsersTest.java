import Models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
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

    public Users  setupUser() {
        return new Users("Manager", "Ensure operations are conducted properly", "Communications department");
    }

}