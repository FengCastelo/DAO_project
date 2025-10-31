package Applications;

import Model.Entities.Department;
import Model.dao.DAOFactory;
import Model.dao.DepartmentDAO;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDao();

        //Tests
        System.out.println("===== TEST 1: Department INSERT =====");
        Department dep = new Department(null,"Medicine");
        departmentDAO.insert(dep);
        System.out.println("Department Inserted!");


        System.out.println("===== TEST 2: Department DELETE =====");
        departmentDAO.deleteById(7);
        System.out.println("Deleted! ");

    }
}
