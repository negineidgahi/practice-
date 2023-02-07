package com.example.tasklist.task;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepository {

    public List<Task> tasks;

    public TaskRepository() {
        this.tasks = new LinkedList<>();
        this.tasks.add(new Task(1, "todo1", "do this 1", 1, true, false));
        this.tasks.add(new Task(2, "todo2", "do this 2", 2, false, true));
        this.tasks.add(new Task(3, "todo3", "do this 3", 3, false, false));

    }
    public List<Task> getTasks() {
        return tasks;
    }

    public void addNewTask(final Task task) {
        tasks.add(task);
    }


    public void removeTask(final Task task) {
        tasks.remove(task);
    }


    public List<Task> getOrderedlist() {
        List<Task> orderedTasks = new ArrayList<>(tasks);
        orderedTasks.sort(Comparator.comparing(Task::getPriority));

        return orderedTasks;
    }

    public List<Task> getInProgress() {
        return tasks.stream().filter(Task::inProgress).collect(Collectors.toList());
    }

    public List<Task> getIsCompleted() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

}
