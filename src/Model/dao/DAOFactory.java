package Model.dao;

import Model.dao.impl.SellerDaoJDBC;

public class DAOFactory {

    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC();
    }
}
