package Models;

import Models.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @BeforeEach
    void setUp() throws  Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void GenerateAllInstancesTrue() {
        News testNews = setupUser();
        assertTrue(testNews instanceof News);
    }

    @Test
    void GenerateUsersInstantiatesWithStringUserAssociatedWithDepartment_true() throws Exception{
        News testNews = setupUser();
        assertEquals("Communications Team", testNews.getUsers());
    }

    @Test
    void GenerateNewsRelatingToDepartmentStringInstantiatesTrue() {
        News testNews = setupUser();
        assertEquals("BBI decision rejected", testNews.getHeadlines());
    }

    public News setupUser() {
        return new News("Communications Team", "BBI decision rejected");
    }

}