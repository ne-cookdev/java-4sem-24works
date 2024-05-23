package com.example.lesson16.service;

import com.example.lesson16.model.Departure;
import com.example.lesson16.model.PostOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class SchedulerServiceImpl {

    @Autowired
    com.example.lesson16.service.DepartureServiceImplementation departureService;
    com.example.lesson16.service.PostOfficeServiceImplementation postOfficeService;


    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() {
        System.out.println("Sheduled");
        File folder = new File("../ScheduledFiles");
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                f.delete();
            }
        }

        File itemFile = new File("../ScheduledFiles/departures.txt");
        if(!itemFile.exists()){
            try {
                itemFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File orderFile = new File("../ScheduledFiles/postoffice.txt");
        if(!orderFile.exists()){
            try {
                orderFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter itemWriter;

        try {
            itemWriter = new FileWriter(itemFile.getAbsolutePath(), false);
            List<Departure> departures = departureService.getDepartures();
            for (Departure u : departures) {
                itemWriter.append(u.toString());
                itemWriter.append("\n");
            }
            itemWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter orderWriter;

        try {
            orderWriter = new FileWriter(orderFile.getAbsolutePath(), false);
            List<PostOffice> postOffices = postOfficeService.getPostOffices();
            for (PostOffice u : postOffices) {
                orderWriter.append(u.toString());
                orderWriter.append("\n");
            }
            orderWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}