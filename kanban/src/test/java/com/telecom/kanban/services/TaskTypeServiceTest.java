package com.telecom.kanban.services;

import com.telecom.kanban.model.TaskStatus;
import com.telecom.kanban.model.TaskType;
import com.telecom.kanban.repository.TaskTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTypeServiceTest {

    @Autowired
    private TaskTypeService taskTypeService;

    @Test
    void addTaskType() {
        TaskType taskType = taskTypeService.addTaskType(new TaskType("TestLabel"));
        assertNotNull(taskType);
        assertNotNull(taskType.getId());
        assertEquals("TestLabel",taskType.getLabel());
    }
}