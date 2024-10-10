package com.CloudAssignment.homework1.formats;


public class MemoryDetails {

    private long totalMemory;
    private long freeMemory;
    private long usedMemory;

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public MemoryDetails(long totalMemory, long freeMemory) {
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
        this.usedMemory = totalMemory - freeMemory;
    }
}
