package Dao;

import Models.Department;
import Models.Users;

import java.util.List;

public interface UsersDao {
    //List
    List<Users> getAll();

    //Create
    void add(Users user);
    void addUserToDepartment(Users user, Department department);

    //Read
    Users findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllUsers();
}
