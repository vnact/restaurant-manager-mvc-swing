package utils;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public enum EmployeePermission {
    MANAGER("manager", "Quản lý"),
    STAFF("staff", "Nhân viên"),
    INACTIVE("inactive", "Nghỉ việc");
    private String id, name;

    EmployeePermission(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EmployeePermission getById(String id) {
        for (EmployeePermission e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return STAFF;
    }

    public static EmployeePermission getByName(String name) {
        for (EmployeePermission e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return STAFF;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
