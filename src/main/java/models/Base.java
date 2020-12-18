package models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @createAt Nov 24, 2020
 * @author Tran Duc Cuong <clonebmn2itt@gmail.com>
 * Mode mẫu
 */
public class Base extends Model {

    int id;

    public static Base getFromResultSet(ResultSet rs) throws SQLException {
        Base c = new Base();
        return c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{};
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
