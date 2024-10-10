package com.CloudAssignment.homework1.formats;

public class Bandwidth {
    private double uploadBandwidth;
    private double downloadBandwidth;

    public Bandwidth(double uploadBandwidth, double downloadBandwidth) {
        this.uploadBandwidth = uploadBandwidth;
        this.downloadBandwidth = downloadBandwidth;
    }

    public double getUploadBandwidth() {
        return uploadBandwidth;
    }

    public void setUploadBandwidth(double uploadBandwidth) {
        this.uploadBandwidth = uploadBandwidth;
    }

    public double getDownloadBandwidth() {
        return downloadBandwidth;
    }

    public void setDownloadBandwidth(double downloadBandwidth) {
        this.downloadBandwidth = downloadBandwidth;
    }
}
