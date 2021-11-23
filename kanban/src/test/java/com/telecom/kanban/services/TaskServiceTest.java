package com.telecom.kanban.services;

import com.telecom.kanban.model.Task;
import com.telecom.kanban.model.TaskStatus;
import com.telecom.kanban.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskStatusService taskStatusService;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    void findAllTasks() {
        Collection<Task> tasks = taskService.findAllTasks();
        assertEquals(3,tasks.size());
    }

    @Test
    void findTask() {
        Task task = taskService.addTask(new Task("TestTask",1,0,new Date()));
        Optional<Task> taskOptional = taskService.findTask(task.getId());
        assertTrue(taskOptional.isPresent());
        assertEquals(taskOptional.get().getId(),task.getId());
    }

    @Test
    void addTask() {
        Task task = taskService.addTask(new Task("TestTask",1,0,new Date()));
        assertNotNull((task));
        assertNotNull(task.getId());
        assertEquals("TestTask",task.getTitle());
    }

    @Test
    void moveRightTask() {
        Task task = taskService.addTask(new Task("TestTask",1,0,new Date()));
        TaskStatus taskStatus = taskStatusService.findTaskStatusByLabel("Backlog").iterator().next();
        task.setTaskStatus(taskStatus);
        taskRepository.save(task);
        taskService.moveRightTask(task);
        assertEquals("To Do",task.getTaskStatus().getLabel());
    }

    @Test
    void moveLeftTask() {
        Task task = taskService.addTask(new Task("TestTask",1,0,new Date()));
        TaskStatus taskStatus = taskStatusService.findTaskStatusByLabel("Done").iterator().next();
        task.setTaskStatus(taskStatus);
        taskRepository.save(task);
        taskService.moveLeftTask(task);
        assertEquals("Testing",task.getTaskStatus().getLabel());
    }
}