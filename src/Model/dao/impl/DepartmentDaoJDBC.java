package Model.dao.impl;

import Model.Entities.Department;
import Model.dao.DepartmentDAO;
import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDAO {

    private final Connection connection;
    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = connection.prepareStatement(
                    "INSERT INTO department (Name) "
                            + "VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else{
                throw new DbException("Unexpected Error! No rows affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "DELETE FROM department WHERE Id = ?");

            st.setInt(1, id);

            int rows = st.executeUpdate();

            if(rows == 0){
                throw new DbIntegrityException("Error: The department ID was not found.");
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
