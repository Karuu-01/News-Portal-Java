package Dao;

import Models.News;

import java.util.List;

public interface NewsDao {
    //List
    List<News> getAll();

    //Create
    void add(News news);

    //Read
    News findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllArticles();
}
