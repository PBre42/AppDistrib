package com.telecom.kanban.services;

import com.telecom.kanban.model.TaskStatus;
import com.telecom.kanban.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TaskStatusService {
    @Autowired
    private TaskStatusRepository taskStatusRepository;
    public Collection<TaskStatus> findTaskStatusByLabel(String label){return taskStatusRepository.findByLabel(label) ;}
    public TaskStatus addTaskStatus(TaskStatus taskStatus){return taskStatusRepository.save(taskStatus);}
}
