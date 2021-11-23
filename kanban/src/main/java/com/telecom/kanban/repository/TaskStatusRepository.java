package com.telecom.kanban.repository;

import com.telecom.kanban.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    Collection<TaskStatus> findByLabel(String label);
}
