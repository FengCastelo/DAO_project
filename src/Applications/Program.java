package Applications;

import Model.Entities.Seller;
import Model.dao.DAOFactory;
import Model.dao.SellerDAO;

public class Program {
    public static void main(String[] args) {

        SellerDAO sellerDAO = DAOFactory.createSellerDao();

        System.out.println("===== TEST 1: seller FindById =====");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        
    }
}