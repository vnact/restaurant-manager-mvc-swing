package utils;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public enum EmployeePermission {
    MANAGER("manager", "Quản lý", 2),
    STAFF("staff", "Nhân viên", 1),
    INACTIVE("inactive", "Nghỉ việc", 0);
    private String id, name;
    private int priority;

    EmployeePermission(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
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

    public int compare(EmployeePermission other) {
        return priority - other.priority;
    }

}
