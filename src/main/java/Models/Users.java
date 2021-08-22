package Models;

public class Users {
private String name;
private String roles;
private String departments;

    public Users(String name, String roles, String departments) {
        this.name = name;
        this.roles =  roles;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }
}
