package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import utils.TableStatus;

/**
 * @createAt Nov 28, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class Table extends Model {

    protected int id;
    protected String name;
    protected TableStatus status;

    public Table() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public static Table getFromResultSet(ResultSet rs) throws SQLException {
        Table t = new Table();
        t.setId(rs.getInt("id"));
        t.setName(rs.getNString("name"));
        t.setStatus(TableStatus.getById(rs.getNString("status")));
        return t;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
            this.getId(), this.getName(), this.getStatus().getName()
        };
    }

}
