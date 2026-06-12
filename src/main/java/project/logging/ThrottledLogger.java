// ThrottledLogger.java
package project.logging;

public class ThrottledLogger {
    private final long intervalMillis;
    private long lastLogTime = -1;

    public ThrottledLogger(long intervalMillis) {
        this.intervalMillis = intervalMillis;
    }

    public synchronized void log(String message){
        long currentTime = System.currentTimeMillis();

        if(lastLogTime == -1 || currentTime - lastLogTime >= intervalMillis){
            System.out.println(message);
            lastLogTime = currentTime;
        }
    }
}
