package Models;

public class News {

    private String users;
    private String headlines;

    public News(String users, String headlines) {
        this.users = users;
        this.headlines = headlines;
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
}
