package com.telecom.kanban.model;

import com.telecom.kanban.repository.TaskRepository;
import com.telecom.kanban.services.DeveloperService;
import com.telecom.kanban.services.TaskService;
import com.telecom.kanban.services.TaskStatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTest {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusService taskStatusService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private DeveloperService developerService;

    @Test
    void addDeveloper() {
        Task task = new Task("TestTask",1,0,new Date());
        Developer developer = new Developer("TestFirstname","TestLastname","TestPassword","developermail@test.com",new Date());
        task.addDeveloper(developer);
        assertTrue(task.getDevelopers().contains(developer));
    }
}