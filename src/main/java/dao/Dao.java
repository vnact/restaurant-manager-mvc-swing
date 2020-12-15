package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @param <T>
 * @createAt Nov 11, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public interface Dao<T> {

    /**
     *
     * @return {@code 123}
     * @throws java.sql.SQLException
     */
    ArrayList<T> getAll() throws SQLException;

    T get(int id) throws SQLException;

    void save(T t) throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void deleteById(int id) throws SQLException;
}
