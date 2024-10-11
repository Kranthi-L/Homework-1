package com.CloudAssignment.homework1.services;

import com.CloudAssignment.homework1.formats.CpuUsage;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class CpuService {

    OperatingSystemMXBean osb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    public CpuUsage getCpuUsage() {
        try{
            return new CpuUsage(osb.getCpuLoad()*100);//percentage
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw(e);
        }
    }
}
