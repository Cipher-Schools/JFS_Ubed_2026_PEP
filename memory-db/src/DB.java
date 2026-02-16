import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;





public class DB {
    private Map<Integer, Entry> storage = new HashMap<>();
    boolean running = true;

    public DB() {
        startCleanupThread();
    }

    private void startCleanupThread() {
        Thread cleaner = new Thread(() -> {
            while(true) {
                if(running) {
                    cleanupExpiredKeys();
                }

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        cleaner.setDaemon(true); 
        cleaner.start();
    }

    private synchronized void cleanupExpiredKeys() {
        Iterator<Map.Entry<Integer, Entry>> iterator = storage.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, Entry> entry = iterator.next();
            if(entry.getValue().isExpired()) {
                iterator.remove();
            }
        }
    }

    public void start(){
        running = true;
        System.out.println("Database started");
    };

    public void stop(){
        running = false;
        System.out.println("Database Stopped");
    };

    public void checkRunning() {
        if(!running) {
            throw new RuntimeException("Database is not running");
        }
    }

    public synchronized void put(int key, String value, long ttlMillis) {
        checkRunning();
        storage.put(key, new Entry(value, ttlMillis));
        System.out.println(value + " value added at " + key + " with " + ttlMillis/1000 + "secs");
    }

    public synchronized String get(int key) {
        checkRunning();
        Entry val = storage.get(key);

        //logic remove that value
        if(val == null) return null;

        if(val.isExpired()) {
            storage.remove(key);
            return null;
        }
        return val.getValue();
    };

    public synchronized void delete(int key) {
        checkRunning();
        storage.remove(key);
        System.out.println("Deleted value at key " + key);
    };

}
