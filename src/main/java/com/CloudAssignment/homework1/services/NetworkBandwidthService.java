package com.CloudAssignment.homework1.services;

<<<<<<< HEAD
=======
import com.CloudAssignment.homework1.formats.Bandwidth;
>>>>>>> 476cbf9 (Changed Bandwidth)
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;




@Service
public class NetworkBandwidthService {

<<<<<<< HEAD
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
=======
    public Object getBandwidth() {
        try{
            SystemInfo systemInfo = new SystemInfo();
            HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
            double previousTime = System.currentTimeMillis();
            double currentReceivedBytes=0.0;
            double currentSentBytes = 0.0;
            for (NetworkIF networkIF: hardwareAbstractionLayer.getNetworkIFs()){
                currentReceivedBytes+=networkIF.getBytesRecv();
>>>>>>> 476cbf9 (Changed Bandwidth)
                currentSentBytes+=networkIF.getBytesSent();
            }
            double currentTime = System.currentTimeMillis();
            double timeIntervalInSeconds = (currentTime-previousTime)/1000;
<<<<<<< HEAD
            double uploadBandwidth = (currentSentBytes)*8/timeIntervalInSeconds;
            return uploadBandwidth/Math.pow(10,9);
=======
            double downloadBandwidth = currentReceivedBytes*8/timeIntervalInSeconds;
            double uploadBandwidth = (currentSentBytes)*8/timeIntervalInSeconds;
            return new Bandwidth(uploadBandwidth/Math.pow(10,9), downloadBandwidth/Math.pow(10,9));
>>>>>>> 476cbf9 (Changed Bandwidth)
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }
}