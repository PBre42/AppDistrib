package com.telecom.kanban.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class TaskStatus{

    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String label;

    @ManyToMany(mappedBy = "taskStatus",cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private Set<Task> tasks;

    public TaskStatus(String label) {
        this.label = label;
    }
}
