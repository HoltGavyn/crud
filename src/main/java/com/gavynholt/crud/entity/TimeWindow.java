package com.gavynholt.crud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="time_window")
public class TimeWindow {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_window_id")
    private int id;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_time")
    private String endTime;
    @JsonBackReference
    @OneToOne(mappedBy="timeWindow",
            cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Patrol patrol;

    public TimeWindow() {
    }

    public TimeWindow(String start, String end, Patrol patrol) {
        this.startTime = start;
        this.endTime = end;
        this.patrol = patrol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Patrol getPatrol() {
        return patrol;
    }

    public void setPatrol(Patrol patrol) {
        this.patrol = patrol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TimeWindow{");
        sb.append("id=").append(id);
        sb.append(", start='").append(startTime).append('\'');
        sb.append(", end='").append(endTime).append('\'');
        sb.append(", patrol=").append(patrol);
        sb.append('}');
        return sb.toString();
    }
}
