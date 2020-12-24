package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * createAt Dec 24, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public abstract class Dao<T> {

    Connection conn = Database.getInstance().getConnection();

    public abstract ArrayList<T> getAll() throws SQLException;

    public abstract T get(int id) throws SQLException;

    public abstract void save(T t) throws SQLException;

    public abstract void update(T t) throws SQLException;

    public abstract void delete(T t) throws SQLException;

    public abstract void deleteById(int id) throws SQLException;
}
