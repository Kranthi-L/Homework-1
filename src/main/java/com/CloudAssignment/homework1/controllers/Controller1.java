package com.CloudAssignment.homework1.controllers;

import com.CloudAssignment.homework1.services.CpuService;
import com.CloudAssignment.homework1.services.DiskService;
import com.CloudAssignment.homework1.services.MemoryService;
import com.CloudAssignment.homework1.services.NetworkBandwidthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller1 {

    @Autowired
    DiskService diskService;

    @Autowired
    MemoryService memoryService;

    @Autowired
    CpuService cpuService;

    @Autowired
    NetworkBandwidthService networkBandwidthService;

    @GetMapping(path = "/disk")
    public ResponseEntity<Object> getDisk(){
        try{
            return  ResponseEntity.ok(diskService.getDiskSpace());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path = "/mem")
    public ResponseEntity<Object> getMemory(){
        try{
            return  ResponseEntity.ok(memoryService.getMemoryDetails());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path = "/cpu")
    public ResponseEntity<Object> getCpu(){
        try{
            return ResponseEntity.ok(cpuService.getCpuUsage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping(path="/net")
    public ResponseEntity<Object> getBandwidth(){
        try{
            return ResponseEntity.ok(networkBandwidthService.getBandwidth());
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
