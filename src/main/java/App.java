import com.google.gson.Gson;
import Dao.Sql2oDepartmentDao;
import Dao.Sql2oNewsDao;
import Dao.Sql2oUsersDao;
import Models.Department;
import Models.News;
import Models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if(processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    public static void main (String[] args) {
        port(getHerokuAssignedPort());

        Sql2oDepartmentDao departmentDao;
        Sql2oUsersDao usersDao;
        Sql2oNewsDao newsDao;
        Connection con;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:postgresql://ec2-52-86-2-228.compute-1.amazonaws.com:5432/dbikgoniut6b1v";
        Sql2o sql2o = new Sql2o(connectionString, "pjvyfidsoyyhvx", "68f89c9557b0c3ef5fc79348fcdd903356b835e9ec642ba9696d4c0508444744");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        con = sql2o.open();



        get("/", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });


        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(usersDao.getAll());
        });

        get("/users/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int usersId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(usersDao.findById(usersId));
        });

        post("/users/new", "application/json", (req, res) -> {
            Users testUser = gson.fromJson(req.body(), Users.class);
            usersDao.add(testUser);
            res.status(201);
            res.type("application/json");
            return gson.toJson(testUser);
        });

        post("/departments/new", "application/json", (req, res) -> {
            Department testDepartment = gson.fromJson(req.body(), Department.class);
            departmentDao.add(testDepartment);
            res.status(201);
            res.type("application/json");
            return gson.toJson(testDepartment);
        });

        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        get("/departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(departmentId));
        });

        post("/news/new", "application/json", (req, res) -> {
            News testNews = gson.fromJson(req.body(), News.class);
            newsDao.add(testNews);
            res.status(201);
            res.type("application/json");
            return gson.toJson(testNews);
        });

        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(newsDao.getAll());
        });

        get("/news/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.findById(departmentId));
        });

        post("/departments/:departmentId/users/new", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("departmentId"));
            Users testUser = gson.fromJson(req.body(), Users.class);

            testUser.setId(departmentId);
            usersDao.add(testUser);
            res.status(201);
            return gson.toJson(testUser);
        });


        after((request, response) -> {
            response.type("application/json");
        });
    }

}
