// Profiler.java
package project.util;

public class Profiler {
    private long startTime;

    public void start(){
        startTime = System.nanoTime();
    }

    public void stop(String operation){
        long durationNs = System.nanoTime() - startTime;
        long durationMs = durationNs / 1_000_000;

        System.out.println("[PROFILE] " + operation + " took " + durationMs + " ms");
    }
}
