package com.example.tasklist.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Task {

    @Id
    @Column
    int taskID;
    @Column
    String taskName;
    @Column
    String info;
    @Column
    int priority;
    @Column
    boolean inProgress;
    @Column
    boolean isCompleted;

    public Task() {

    }

    public Task(int taskID, String taskName, String info, int priority, boolean inProgress, boolean isCompleted) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.info = info;
        this.priority = priority;
        this.inProgress = inProgress;
        this.isCompleted = isCompleted;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getInfo() {
        return info;
    }

    public int getPriority() {
        return priority;
    }

    public boolean getInProgress() {
        return inProgress;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public boolean inProgress() {
        return false;
    }

    public boolean isCompleted() {
        return false;
    }
}
