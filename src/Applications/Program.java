package Applications;

import Model.Entities.Department;
import Model.Entities.Seller;
import Model.dao.DAOFactory;
import Model.dao.SellerDAO;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDAO sellerDAO = DAOFactory.createSellerDao();

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
    }
}