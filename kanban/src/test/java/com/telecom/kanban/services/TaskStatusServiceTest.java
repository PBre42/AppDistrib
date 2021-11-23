package com.telecom.kanban.services;

import com.telecom.kanban.model.Task;
import com.telecom.kanban.model.TaskStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskStatusServiceTest {

    @Autowired
    private TaskStatusService taskStatusService;

    @Test
    void findTaskStatusByLabel() {
        TaskStatus taskStatus = taskStatusService.addTaskStatus(new TaskStatus("TestLabel"));
        Collection<TaskStatus> taskStatusOptional = taskStatusService.findTaskStatusByLabel(taskStatus.getLabel());
        assertTrue(taskStatusOptional.contains(taskStatus));
    }

    @Test
    void addTaskStatus() {
        TaskStatus taskStatus = taskStatusService.addTaskStatus(new TaskStatus("TestLabel"));
        assertNotNull(taskStatus);
        assertNotNull(taskStatus.getId());
        assertEquals("TestLabel",taskStatus.getLabel());
    }
}