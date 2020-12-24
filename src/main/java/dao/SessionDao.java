package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Session;

/**
 * createAt Dec 24, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class SessionDao extends Dao<Session> {

    @Override
    public ArrayList<Session> getAll() throws SQLException {
        ArrayList<Session> sessions = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `session`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Session session = Session.getFromResultSet(rs);
            sessions.add(session);
        }
        return sessions;
    }

    @Override
    public Session get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Session t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Session t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Session t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
