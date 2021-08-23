package Dao;

import Models.News;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {
    private static Sql2oNewsDao news;
    private static Connection con;

    @BeforeEach
    void setUp() throws Exception{
        String connectionString = "jdbc:postgresql://localhost:5432/news_java";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "myPassword");
        news = new Sql2oNewsDao(sql2o);
        con = sql2o.open();
    }

    @AfterAll
    static void shutDown() throws Exception{
        con.close();
        System.out.println("closed connection");

    }

    @AfterEach
    void tearDown() throws Exception{
        System.out.println("clear database");
        news.clearAllNews();
    }



    @Test
    void newsSetIdCorrectly() throws Exception{
        News testNews = setupNews();
        News testNews1 = setupNews();
        news.add(testNews);
        news.add(testNews1);
        assertEquals(0, news.getAll().size());

    }

    @Test
    void deleteIdCorrectlyOfNews() throws Exception{
        News testNews = setupNews();
        news.add(testNews);
        news.deleteById(testNews.getId());
        assertEquals(0, news.getAll().size());
    }

    @Test
    void clearAllNews() throws Exception{
        News testNews = setupNews();
        News testNews1 = setupNews();
        news.add(testNews);
        news.add(testNews1);
        int newsSize = news.getAll().size();
        news.clearAllNews();
        assertEquals(0, news.getAll().size());
    }

    public News setupNews(){
        return new News("Sports", "Sports Department", "Todd misses a big chance", "Todd");
    }
}