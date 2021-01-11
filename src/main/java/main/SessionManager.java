package main;

import dao.SessionDao;
import java.sql.SQLException;
import java.sql.Timestamp;
import models.Employee;
import models.Session;

/**
 * createAt Dec 23, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class SessionManager {

    public static Session session;
    static SessionDao sessionDao = new SessionDao();

    public SessionManager() {
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        SessionManager.session = session;
    }

    public static void create(Employee e) throws SQLException {
        if (e == null) {
            throw new SQLException("Nguoi dung khong hop le!");
        }
        Session ss = new Session();
        ss.setEmployee(e);
        ss.setMessage("login");
        ss.setStartTime(new Timestamp(System.currentTimeMillis()));
        sessionDao.save(ss);
        Session sss = sessionDao.getLast(e.getId());
        setSession(sss);
    }

    public static void update() throws SQLException {
        if (session == null) {
            throw new SQLException("Ban chua dang nhap!");
        }
        session.setMessage("logout");
        session.setEndTime(new Timestamp(System.currentTimeMillis()));
        sessionDao.update(session);
        setSession(null);
    }

}
