package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.LoadConfig;

/**
 * @createAt Nov 11, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class Database {

    private static final LoadConfig dbConfig = LoadConfig.getIntanse();
    private static Database instance = null;
    private static final String JDBC_STRING = dbConfig.getProperties("url");
    private static final String DB_USER = dbConfig.getProperties("username");
    private static final String DB_PASS = dbConfig.getProperties("password");
    private static final String DB_NAME = dbConfig.getProperties("database");
    private static final String URL = JDBC_STRING + "/" + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Connection conn = null;

    private Database() {
        try {
            Class.forName(dbConfig.getProperties("driver_class"));
            this.conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            System.out.println("Kết nối cơ sở dữ liệu thành công!");
        } catch (ClassNotFoundException e) {
            System.out.println("Chưa cài driver mysql!");
            System.out.println(e.toString());
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Kết nối cơ sở dữ liệu thất bại:");
            System.out.println(e.toString());
            System.exit(0);
        }

    }

    public Connection getConnection() {
        return this.conn;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static void main(String[] args) {
        try {
            Connection connection = getInstance().getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT CURRENT_TIMESTAMP";
            ResultSet rs = stmt.executeQuery(query);
            // show data
            while (rs.next()) {
                System.out.println(rs.getDate("CURRENT_TIMESTAMP").toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
