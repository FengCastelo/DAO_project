package Applications;

import Model.Entities.Department;
import Model.Entities.Seller;
import Model.dao.DAOFactory;
import Model.dao.SellerDAO;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDAO sellerDAO = DAOFactory.createSellerDao();

        //Tests
        System.out.println("===== TEST 1: seller findById =====");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n===== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===== TEST 3: seller findAll =====");
        list = sellerDAO.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }


        System.out.println("\n===== TEST 4: seller INSERT =====");
        Seller newSeller = new Seller(4000.0, new Date(), department, "greg@gmail.com", null, "Greg");
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! new Id = " + newSeller.getId());
        

        System.out.println("\n===== TEST 5: seller UPDATE =====");
        seller = sellerDAO.findById(1);
        seller.setName("Bruce Wayne");
        seller.setEmail("brucewaynebatman@gmail.com");
        sellerDAO.update(seller);
        System.out.println("Update completed! ");


        System.out.println("\n===== TEST 6: seller DELETE =====");
        System.out.println("Enter a id for delete test: ");
        int id = sc.nextInt();
        sellerDAO.deleteById(id);

        System.out.println("The seller with id " + id + " was deleted!");
        sc.close();
    }
}