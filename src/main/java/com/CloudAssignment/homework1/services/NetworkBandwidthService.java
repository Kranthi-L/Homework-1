package com.CloudAssignment.homework1.services;

import com.CloudAssignment.homework1.formats.Bandwidth;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;




@Service
public class NetworkBandwidthService {

    public Object getBandwidth() {
        try{
            SystemInfo systemInfo = new SystemInfo();
            HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
            double previousTime = System.currentTimeMillis();
            double currentReceivedBytes=0.0;
            double currentSentBytes = 0.0;
            for (NetworkIF networkIF: hardwareAbstractionLayer.getNetworkIFs()){
                currentReceivedBytes+=networkIF.getBytesRecv();
                currentSentBytes+=networkIF.getBytesSent();
            }
            double currentTime = System.currentTimeMillis();
            double timeIntervalInSeconds = (currentTime-previousTime)/1000;
            double downloadBandwidth = currentReceivedBytes*8/timeIntervalInSeconds;
            double uploadBandwidth = (currentSentBytes)*8/timeIntervalInSeconds;
            return new Bandwidth(uploadBandwidth/Math.pow(10,9), downloadBandwidth/Math.pow(10,9));
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }
}