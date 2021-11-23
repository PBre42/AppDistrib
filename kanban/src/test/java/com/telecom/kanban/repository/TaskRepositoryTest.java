package com.telecom.kanban.repository;

import com.telecom.kanban.model.Task;
import com.telecom.kanban.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void findAll(){
        Collection<Task> tasks = taskRepository.findAll();
        assertEquals(3,tasks.size());
    }

    @Test
    void save(){
        Task task = taskRepository.save(new Task("TestTask",1,0,new Date()));
        assertNotNull(task);
    }
}