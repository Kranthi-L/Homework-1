package com.CloudAssignment.homework1.services;

import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;




@Service
public class NetworkBandwidthService {

    private HardwareAbstractionLayer hardwareAbstractionLayer;

    public double getDownloadBandwidth() {
        try{
            SystemInfo systemInfo = new SystemInfo();
            hardwareAbstractionLayer = systemInfo.getHardware();
            double previousTime = System.currentTimeMillis();
            double currentReceivedBytes=0.0;
            for (NetworkIF networkIF: hardwareAbstractionLayer.getNetworkIFs()){
                currentReceivedBytes+=networkIF.getBytesRecv();
            }
            double currentTime = System.currentTimeMillis();
            double timeIntervalInSeconds = (currentTime-previousTime)/1000;
            double downloadBandwidth = currentReceivedBytes*8/timeIntervalInSeconds;
            return downloadBandwidth/Math.pow(10,9);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }

    public double getUploadBandwidth() {
        try{
            SystemInfo systemInfo = new SystemInfo();
            hardwareAbstractionLayer = systemInfo.getHardware();
            double previousTime = System.currentTimeMillis();
            double currentSentBytes = 0.0;
            for(NetworkIF networkIF: hardwareAbstractionLayer.getNetworkIFs()){
                currentSentBytes+=networkIF.getBytesSent();
            }
            double currentTime = System.currentTimeMillis();
            double timeIntervalInSeconds = (currentTime-previousTime)/1000;
            double uploadBandwidth = (currentSentBytes)*8/timeIntervalInSeconds;
            return uploadBandwidth/Math.pow(10,9);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }
}