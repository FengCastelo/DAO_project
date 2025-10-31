package Applications;

import java.util.List;
import java.util.Scanner;

import Model.dao.DaoFactory;
import Model.dao.DepartmentDAO;
import Model.Entities.Department;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n===== TEST 1: Department INSERT =====");
        Department newDepartment = new Department(6, "Music");
        departmentDao.insert(newDepartment);
        System.out.println(" Inserted! New id: " + newDepartment.getId());

        System.out.println("\n===== TEST 2: DELETE =====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println(" Delete completed! ");

        System.out.println("\n===== TEST 3: Department findById =====");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n===== TEST 4: Department findAll =====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n===== TEST 5: Department UPDATE =====");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println(" Update completed! ");

        sc.close();
    }
}