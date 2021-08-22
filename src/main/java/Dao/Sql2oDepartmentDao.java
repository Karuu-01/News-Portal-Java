package Dao;

import Models.Department;
import Models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;


public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Department> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments").executeAndFetch(Department.class);
        }
    }

    @Override
    public List<Users> getAllDepartmentUsers(int departmentId) {
        ArrayList<Users> users = new ArrayList<>();

        String joinQuery = "SELECT usersId FROM department_users WHERE departmentId = :departmentId";

        try (Connection con = sql2o.open()) {
            List<Integer> allUsersIds = con.createQuery(joinQuery)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer usersId : allUsersIds) {
                String getUserQuery = "SELECT * FROM users WHERE id = :usersId";
                users.add(
                        con.createQuery(getUserQuery)
                                .addParameter("usersId", usersId)
                                .executeAndFetchFirst(Users.class)
                );
            }
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
        return users;
    }



    @Override
    public void add(Department departments) {
        String sql = "INSERT INTO departments (name, description, employee) VALUES (:name, :description, :employee )";
           try (Connection con = sql2o.open()){
               int id = (int) con.createQuery(sql,true).bind(departments).executeUpdate().getKey();
               departments.setId(id);
           }catch (Sql2oException ex) {
               System.out.println(ex);
           }
    }

    @Override
    public Department findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id").addParameter("id", id).executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id=:id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).addParameter("id", id).executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void clearAllDepartments() {
        String sql = "DELETE from departments";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
