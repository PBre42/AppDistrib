package com.telecom.kanban;

import com.telecom.kanban.model.Developer;
import com.telecom.kanban.model.Task;
import com.telecom.kanban.model.TaskStatus;
import com.telecom.kanban.model.TaskType;
import com.telecom.kanban.services.DeveloperService;
import com.telecom.kanban.services.TaskService;
import com.telecom.kanban.services.TaskStatusService;
import com.telecom.kanban.services.TaskTypeService;
import org.hibernate.criterion.InExpression;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class KanbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanbanApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext, DeveloperService developerService, TaskService taskService, TaskStatusService taskStatusService, TaskTypeService taskTypeService){
		return args -> {
			populateDevelopers(developerService);
			populateTasks(taskService);
			populateTaskStatus(taskStatusService);
			populateTaskType(taskTypeService);
		};
	}

	public void populateDevelopers(DeveloperService developerService){
		List<Developer> developers = new ArrayList<>();
		developers.add(new Developer("Quentin","Viricel","psswd","quentin.viricel@email.fr",new Date()));
		developers.add(new Developer("Valentin","Descomps","psswd","valentin.descomps@email.fr",new Date()));
		developers.add(new Developer("Aymeric","Faure","psswd","aymeric.faure@email.fr",new Date()));

		for(Developer developer : developers){
			developerService.addDeveloper(developer);
		}
	}
	public void populateTasks (TaskService taskService){
		List<Task>tasks= new ArrayList<>();
		tasks.add(new Task("Task1",1,0,new Date()));
		tasks.add(new Task("Task2",1,0,new Date()));
		tasks.add(new Task("Task3",1,0,new Date()));

		for (Task task : tasks){
			taskService.addTask(task);
		}
	}
	public void populateTaskStatus(TaskStatusService taskStatusService){
		List<TaskStatus> taskStatuses=new ArrayList<>();
		taskStatuses.add(new TaskStatus(("Backlog")));
		taskStatuses.add(new TaskStatus(("To Do")));
		taskStatuses.add(new TaskStatus(("In Progress")));
		taskStatuses.add(new TaskStatus(("Testing")));
		taskStatuses.add(new TaskStatus(("Done")));

		for (TaskStatus taskStatus : taskStatuses){
			taskStatusService.addTaskStatus(taskStatus);
		}
	}

	public void populateTaskType(TaskTypeService taskTypeService){
		List<TaskType> taskTypes = new ArrayList<>();
		taskTypes.add(new TaskType(("BDD")));
		taskTypes.add(new TaskType(("Backend")));
		taskTypes.add(new TaskType(("Frontend")));

		for (TaskType taskType : taskTypes){
			taskTypeService.addTaskType(taskType);
		}

	}
}
