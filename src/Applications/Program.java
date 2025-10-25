package Applications;

import Model.Entities.Seller;
import Model.dao.DAOFactory;
import Model.dao.SellerDAO;

public class Program {
    public static void main(String[] args) {

        SellerDAO sellerDAO = DAOFactory.createSellerDao();

        Seller seller = sellerDAO.findById(3);

        System.out.println(seller);
    }
}