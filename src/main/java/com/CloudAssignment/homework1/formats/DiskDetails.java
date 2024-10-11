package com.CloudAssignment.homework1.formats;

public class DiskDetails {

    private double total;

    private double used;

    public DiskDetails(double total, double used) {
        this.total = total;
        this.used = used;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getUsed() {
        return used;
    }

    public void setUsed(double used) {
        this.used = used;
    }
}
