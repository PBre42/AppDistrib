package com.telecom.kanban.repository;

import com.telecom.kanban.model.Developer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DeveloperRepositoryTest {
    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void findAll(){
        Collection<Developer> developers = developerRepository.findAll();
        assertEquals(3,developers.size());
    }

}