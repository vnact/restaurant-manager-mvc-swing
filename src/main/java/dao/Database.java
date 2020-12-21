package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.LoadConfig;

/**
 * @createAt Nov 11, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class Database {

    private static final LoadConfig cfg = LoadConfig.getIntanse();
    private static Database instance = null;
    private Connection conn = null;

    private Database() {
        try {
            String connectProperty = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String host = cfg.getProperty("database.host"),
                    port = cfg.getProperty("database.port"),
                    user = cfg.getProperty("database.username"),
                    password = cfg.getProperty("database.password"),
                    name = cfg.getProperty("database.name");
            Class.forName(cfg.getProperty("database.driver_class"));
            String url = String.format("jdbc:%s://%s:%s/%s?%s", cfg.getProperty("database.jdbc"), host, port, name, connectProperty);
            this.conn = DriverManager.getConnection(url, user, password);
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

}
