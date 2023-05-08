package e08_Collection.ArrayDeque.PriorityQueue.onlineShop;

public enum Priority {
    HIGH(0),
    MEDIUM(1),
    LOW(2);

    private final int code;

    Priority(int code) {
        this.code = code;
    }

    public static Priority getHIGH(){
        return HIGH;
    }

    public static Priority getMEDIUM(){
        return MEDIUM;
    }

    public static Priority getLOW(){
        return LOW;
    }

    public int getCode() {
        return code;
    }
}
