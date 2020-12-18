package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Base;

/**
 * @createAt Nov 25, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 * Dao mẫu
 */
public class BaseDao implements Dao<Base> {

    Connection conn = Database.getInstance().getConnection();

    @Override
    public ArrayList<Base> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Base get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Base t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Base t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Base t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
