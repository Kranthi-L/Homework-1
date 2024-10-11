package com.CloudAssignment.homework1.services;

import com.CloudAssignment.homework1.formats.DiskDetails;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.system.DiskSpaceHealthIndicator;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataSize;

import java.io.File;

@Service
public class DiskService {

    private final DiskSpaceHealthIndicator diskSpaceHealthIndicator = new DiskSpaceHealthIndicator(new File("/"), DataSize.ofBytes(1));

    public DiskDetails getDiskSpace(){
        try {
            Health health = diskSpaceHealthIndicator.health();
            double totalSpace = ((long) health.getDetails().get("total")/Math.pow(10,9) );
            double freeSpace = ((long) health.getDetails().get("free")/Math.pow(10,9) );
            return new DiskDetails(totalSpace,freeSpace);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw(e);
        }
    }

}
