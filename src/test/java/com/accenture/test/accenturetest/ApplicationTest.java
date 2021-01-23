package com.accenture.test.accenturetest;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ApplicationTest {

    @Autowired
    private PersonService personService;

    @Test
    public void app_test() throws Exception {
        List<Person> personList = personService.readFromFile("classpath:/persons.txt");

        log.info("Found: {} persons.", personList.size());


        for(Person person : personList) {
            log.info("Nume: {}, varsta: {}", person.getFullName(), person.getCurrentAge());
        }
    }
}
