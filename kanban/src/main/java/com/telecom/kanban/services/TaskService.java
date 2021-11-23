package com.telecom.kanban.services;

import com.telecom.kanban.model.Task;
import com.telecom.kanban.model.TaskStatus;
import com.telecom.kanban.repository.TaskRepository;
import com.telecom.kanban.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusService taskStatusService;
    public Collection<Task> findAllTasks(){return taskRepository.findAll();}
    public Optional<Task> findTask(Long id){return taskRepository.findById(id);}

    public Task addTask(Task task){return taskRepository.save(task);}
    public Task moveRightTask(Task task)
    {
        TaskStatus taskStatus = task.getTaskstatus();
        TaskStatus nextStatus = switch (taskStatus.getLabel()) {
            case "Backlog" -> taskStatusService.findTaskStatusByLabel("To Do").iterator().next();
            case "To Do" -> taskStatusService.findTaskStatusByLabel("In Progress").iterator().next();
            case "In Progress" -> taskStatusService.findTaskStatusByLabel("Testing").iterator().next();
            case "Testing" -> taskStatusService.findTaskStatusByLabel("Done").iterator().next();
            default -> null;
        };
        if (nextStatus != null) {
            task.setTaskStatus(nextStatus);
            return taskRepository.save(task);
        }
        return task;
    }
    public Task moveLeftTask(Task task){
        TaskStatus taskStatus = task.getTaskStatus();
        TaskStatus previousStatus = switch (taskStatus.getLabel()){
            case "Done" -> taskStatusService.findTaskStatusByLabel("Testing").iterator().next();
            case "Testing" -> taskStatusService.findTaskStatusByLabel("In Progress").iterator().next();
            case "In Progress" -> taskStatusService.findTaskStatusByLabel("To Do").iterator().next();
            case "To Do" -> taskStatusService.findTaskStatusByLabel("Backlog").iterator().next();
            default -> null;
        };
        if(previousStatus!=null){
            task.setTaskStatus(previousStatus);
            return taskRepository.save(task);

        }
        return task;
    }

}
