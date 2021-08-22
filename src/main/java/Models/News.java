package Models;

import java.util.Objects;

public class News {

    private int id;
    private String name;
    private String users;
    private String headlines;
    private String author;

    public News(String name, String users, String headlines, String author) {
        this.name = name;
        this.users = users;
        this.headlines = headlines;
        this.author = author;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return Objects.equals(getName(), news.getName()) && Objects.equals(getUsers(), news.getUsers()) && Objects.equals(getHeadlines(), news.getHeadlines()) && Objects.equals(getAuthor(), news.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUsers(), getHeadlines(), getAuthor());
    }
}
