package com.telecom.kanban.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ChangeLog {

    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private Date occured;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Getter @Setter private Task task;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @Getter @Setter private TaskStatus source;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private TaskStatus target;

    public ChangeLog(Date occured, Task task, TaskStatus source, TaskStatus target) {
        this.occured = occured;
        this.task = task;
        this.source = source;
        this.target = target;
    }
}
