package models;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public abstract class Model {

    public abstract String toString();

    public abstract Object[] toRowTable();
}
