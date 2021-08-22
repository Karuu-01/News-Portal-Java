package Dao;

import Models.Department;
import Models.Users;

import java.util.List;

public interface DepartmentDao {
    //List
    List<Department> getAll();
    List<Users> getAllDepartmentUsers(int departmentId);

    //Create
    void add(Department departments);

    //Read
    Department findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllDepartments();

}
