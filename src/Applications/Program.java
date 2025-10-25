package Applications;

import Model.Entities.Department;
import Model.Entities.Seller;
import Model.dao.DAOFactory;
import Model.dao.SellerDAO;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1, "Books");

        SellerDAO sellerDAO = DAOFactory.createSellerDao();
        
        System.out.println(obj);
    }
}