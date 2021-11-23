package com.telecom.kanban.services;

import com.telecom.kanban.model.TaskType;
import com.telecom.kanban.repository.TaskRepository;
import com.telecom.kanban.repository.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTypeService {
    @Autowired
    private TaskTypeRepository taskTypeRepository;
    public TaskType addTaskType(TaskType taskType){return taskTypeRepository.save(taskType);}
}
