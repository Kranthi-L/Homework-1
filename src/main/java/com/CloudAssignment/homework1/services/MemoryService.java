package com.CloudAssignment.homework1.services;

import com.CloudAssignment.homework1.formats.MemoryDetails;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class MemoryService {

    OperatingSystemMXBean osb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    public MemoryDetails getMemoryDetails() {
        try{
            return new MemoryDetails(getTotalMemory(),getFreeMemory());
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }

    public long getTotalMemory() {
        try{
            return osb.getTotalMemorySize()/(1024 * 1024);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }

    public long getFreeMemory() {
        try{
            return osb.getFreeMemorySize()/(1024 * 1024);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }
}
