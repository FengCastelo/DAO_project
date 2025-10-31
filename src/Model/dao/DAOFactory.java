package Model.dao;

import Model.dao.impl.DepartmentDaoJDBC;
import Model.dao.impl.SellerDaoJDBC;
import db.DB;

public class DAOFactory {

    public static SellerDAO createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
