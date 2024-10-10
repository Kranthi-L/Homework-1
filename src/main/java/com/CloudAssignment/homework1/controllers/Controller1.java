package com.CloudAssignment.homework1.controllers;

import com.CloudAssignment.homework1.DiskSpaceIndicator;
import com.CloudAssignment.homework1.formats.Bandwidth;
import com.CloudAssignment.homework1.formats.CpuUsage;
import com.CloudAssignment.homework1.formats.DiskDetails;
import com.CloudAssignment.homework1.formats.MemoryDetails;
import com.CloudAssignment.homework1.services.NetworkBandwidthService;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.util.List;

@RestController
public class Controller1 {

    OperatingSystemMXBean osb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    @GetMapping(path = "/disk")
    public Object test(){
        try{
            DiskSpaceIndicator di = new DiskSpaceIndicator();
            List<Double> li = di.getDiskSpace();
            DiskDetails d = new DiskDetails();
            d.setTotal(li.get(0));
            d.setUsed(li.get(1));
            return d;
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping(path = "/mem")
    public Object memoryDetails(){
        try{
            long total = osb.getTotalMemorySize();
            long free = osb.getFreeMemorySize();
            return new MemoryDetails(total/(1024 * 1024), free/(1024 * 1024));
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping(path = "/cpu")
    public ResponseEntity<Object> getCpu(){
        try{
            return ResponseEntity.ok(new CpuUsage(osb.getCpuLoad()*100));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path="/net")
    public Object getBandwidth(){
        try{
            NetworkBandwidthService ns = new NetworkBandwidthService();
            return new Bandwidth(ns.getUploadBandwidth(),ns.getDownloadBandwidth());
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
