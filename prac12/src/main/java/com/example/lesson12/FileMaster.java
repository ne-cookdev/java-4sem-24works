package com.example.lesson12;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

@Component
public class FileMaster {
    @Autowired
    private ApplicationArguments args;

    private String hash;

    public FileMaster() {
        hash = "";
    }

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputFile = new FileInputStream("input.txt")) {
            hash = DigestUtils.md5DigestAsHex(inputFile);

            File outputFile = new File("output.txt");
            if (!outputFile.exists()) outputFile.createNewFile();

            FileWriter writer = new FileWriter(outputFile);
            writer.write(hash);
            writer.close();

        } catch (FileNotFoundException e) {
            File outputFile = new File("output.txt");
            if (!outputFile.exists()) outputFile.createNewFile();

            FileWriter writer = new FileWriter(outputFile);
            writer.write("null");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void deleteInputFile() {
        File inputFile = new File("input.txt");

        if (inputFile.exists()) {
            inputFile.delete();
        }
    }
}
