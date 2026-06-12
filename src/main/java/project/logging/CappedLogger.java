//  CappedLogger.java

package project.logging;

import java.util.concurrent.atomic.AtomicInteger;

public class CappedLogger {
    private final int cap;
    private final AtomicInteger count = new AtomicInteger();

    public CappedLogger(int cap){
        this.cap = cap;
    }

    public void log(String message){
        if (count.getAndIncrement() < cap) {
            System.out.println(message);
        }
    }
}
