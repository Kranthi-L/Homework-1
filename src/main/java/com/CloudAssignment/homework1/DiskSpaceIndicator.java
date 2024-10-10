package com.CloudAssignment.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.system.DiskSpaceHealthIndicator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiskSpaceIndicator {


    private final DiskSpaceHealthIndicator diskSpaceHealthIndicator = new DiskSpaceHealthIndicator(new File("/"), DataSize.ofBytes(1));

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public List<Double> getDiskSpace(){
        List<Double> li = new ArrayList<>();
        try {
            Health health = diskSpaceHealthIndicator.health();
            double totalSpace = (double) ((long) health.getDetails().get("total")/Math.pow(10,9) );
            double freeSpace = (double) ((long) health.getDetails().get("free")/Math.pow(10,9) );
            li.add(totalSpace);
            li.add(freeSpace);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return li;
    }


}
