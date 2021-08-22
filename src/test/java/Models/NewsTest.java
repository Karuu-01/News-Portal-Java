package Models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void GenerateAllInstancesTrue() {
        News testNews = setupNews();
        assertTrue(testNews instanceof News);
    }

    @Test
    void GenerateStringNameInstantiatesCorrectlyTrue() {
        News testNews = setupNews();
        assertEquals("BBI", testNews.getName());
    }

    @Test
    void setUseridCorrectly() {
        News testNews = setupNews();
        testNews.setId(2);
        assertNotEquals(1, testNews.getId());
    }

    @Test
    void GenerateUsersInstantiatesWithStringUserAssociatedWithDepartment_true() throws Exception{
        News testNews = setupNews();
        assertEquals("Politics Department", testNews.getUsers());
    }

    @Test
    void GenerateNewsRelatingToDepartmentStringInstantiatesTrue() {
        News testNews = setupNews();
        assertEquals("BBI decision rejected", testNews.getHeadlines());
    }

    @Test
    void GetAuthorInstantiatesCorrectlyWithAuthorString() {
        News testNews = setupNews();
        assertEquals("Brian", testNews.getAuthor());
    }

    @Test
    void setAuthorNameCorrectly() {
        News testNews = setupNews();
        testNews.setAuthor("Rico");
        assertNotEquals("Brian", testNews.getAuthor());
    }

    @Test
    public void setNameSetsCorrectName_String() throws Exception {
        News testNews = setupNews();
        testNews.setName("Politics");
        assertNotEquals("BBI", testNews.getName());
    }

    @Test
    public void setHeadlinesSetsCorrectName_String() throws Exception {
        News testNews = setupNews();
        testNews.setHeadlines("Breaking bridges initiative");
        assertNotEquals("BBI decision rejected", testNews.getHeadlines());
    }

    @Test
    public void setUsersSetsCorrectName_String() throws Exception {
        News testNews = setupNews();
        testNews.setUsers("Politics Team");
        assertNotEquals("Politics Department", testNews.getUsers());
    }

    public News setupNews() {
        return new News("BBI", "Politics Department", "BBI decision rejected", "Brian");
    }

}