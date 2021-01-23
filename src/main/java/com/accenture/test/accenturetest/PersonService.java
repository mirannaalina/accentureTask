package com.accenture.test.accenturetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PersonService {

    @Autowired
    private ResourceLoader resourceLoader;

    public List<Person> readFromFile(String path) throws IOException {

        List<Person> personList = new ArrayList<>();

        File file = resourceLoader.getResource(path).getFile();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if(lineNumber != 0) {

                    String[] items = line.split(";");

                    if(items.length >= 5) {
                        Person person = new Person();
                        person.setId(Integer.parseInt(items[0]));
                        person.setFullName(items[1]);
                        person.setBirthYear(Integer.parseInt(items[2]));
                        person.setPartner(Integer.parseInt(items[3]));
                        person.setFatherId(Integer.parseInt(items[4]));
                        person.setMotherId(Integer.parseInt(items[5]));

                        personList.add(person);
                    } else {
                        System.out.println("Persoana invalida detectata in fisier.");
                    }
                }

                lineNumber++;
            }
        }

        return personList;
    }
}
