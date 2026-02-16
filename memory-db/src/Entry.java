public class Entry {
    private String value;
    private long expiryTime;
    //ttl
    //generic

    public Entry(String value, long ttlMills) {
        this.value = value;
        if(ttlMills == -1) {
            this.expiryTime = -1;
        } else {
            this.expiryTime = System.currentTimeMillis() + ttlMills;
        }
    }

    public String getValue() {
        return value;
    }

    public boolean isExpired() {
        if(expiryTime == -1) return false;      //permament data
        return System.currentTimeMillis() > expiryTime;     // if epoch time is more then expiry time -> true
    }
}
