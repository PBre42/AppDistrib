package com.telecom.kanban.services;

import com.telecom.kanban.model.Developer;
import com.telecom.kanban.repository.DeveloperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeveloperServiceTest {

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void addDeveloper() {
        Developer developer= developerService.addDeveloper(new Developer("TestFirstname","TestLastname","psswd","developer@mail.com",new Date()));
        assertNotNull(developer);
        assertNotNull(developer.getId());
    }

    @Test
    void findDeveloperById() {
        Developer developer= developerService.addDeveloper(new Developer("TestFirstname","TestLastname","psswd","developer@mail.com",new Date()));
        assertNotNull(developer);
        assertNotNull(developer.getId());
        assertEquals("TestFirstname",developer.getFirstname());
    }

    @Test
    void findAllDeveloper() {
        Collection<Developer> developers = developerService.findAllDeveloper();
        assertEquals(3,developers.size());
    }
}