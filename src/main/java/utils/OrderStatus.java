package utils;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public enum OrderStatus {
    UNPAID("unpaid", "Chưa thanh toán"),
    PAID("paid", "Đã thanh toán"),
    CANCEL("cancel", "Bị hủy");
    private String id, name;

    OrderStatus(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static OrderStatus getById(String id) {
        for (OrderStatus e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return UNPAID;
    }

    public static OrderStatus getByName(String name) {
        for (OrderStatus e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return UNPAID;
    }

}
