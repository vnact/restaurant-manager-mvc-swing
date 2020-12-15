package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import utils.StringToSlug;

/**
 * @createAt Dec 1, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class FoodCategory {

    protected int id;
    protected String name;

    public FoodCategory() {
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

    public String getSlug() {
        return StringToSlug.convert(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static FoodCategory getFromResultSet(ResultSet rs) throws SQLException {
        FoodCategory fc = new FoodCategory();
        fc.setId(rs.getInt("id"));
        fc.setName(rs.getNString("name"));
        return fc;
    }

}
