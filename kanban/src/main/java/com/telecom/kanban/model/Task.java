package com.telecom.kanban.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String title;
    @Getter @Setter private Integer nbHoursForecast;
    @Getter @Setter private Integer nbHoursReal;
    @Getter @Setter private Date created;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private TaskType taskType;

    @ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private TaskStatus taskstatus;

    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private Set<Developer> developers;

    @ManyToMany(mappedBy ="task",cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @Getter @Setter private List<ChangeLog> changeLogs;

    public Task(String title, Integer nbHoursForecast, Integer nbHoursReal, Date created) {
        this.title = title;
        this.nbHoursForecast = nbHoursForecast;
        this.nbHoursReal = nbHoursReal;
        this.created = created;
        this.developers = new HashSet<>();
    }

    public Boolean addDeveloper(Developer developer){return developers.add(developer);}

}
