package utils;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public enum LevelPermission {
    BANNED_PERMISSION(0, "Nghỉ việc"),
    MEMBER_PERMISSION(1, "Nhân viên"),
    ADMIN_PERMISSION(2, "Quản trị viên");
    private int id;
    private String name;

    LevelPermission(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static LevelPermission getById(int id) {
        for (LevelPermission e : values()) {
            if (e.id == id) {
                return e;
            }
        }
        return MEMBER_PERMISSION;
    }

    public static LevelPermission getByName(String name) {
        for (LevelPermission e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return MEMBER_PERMISSION;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
