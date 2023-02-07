package com.example.tasklist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//our controller only handles the connection between the Model and the View
@RestController()
@CrossOrigin
public class TaskController {

    TaskRepository taskRepository;

    @Autowired
    public TaskController(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task/all")
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }

    @GetMapping("/task/priority")
    public List<Task> getPriorityList() {
        return taskRepository.getOrderedlist();
    }


    @GetMapping("/task/inProgress")
    public List<Task> getInProgress() {
        return taskRepository.getInProgress();
    }

    @GetMapping("/task/isCompleted")
    public List<Task> getIsCompleted() {
        return taskRepository.getIsCompleted();
    }





    @PostMapping("/task/new")
    public String newTask(@RequestParam int taskID, @RequestParam String taskName, @RequestParam String info, @RequestParam int priority, @RequestParam boolean inProgress, @RequestParam boolean isCompleted){
       Task task = new Task(taskID, taskName, info, priority, inProgress, isCompleted);
       taskRepository.addNewTask(task);
       return "Success";
    }

    @DeleteMapping("/task/remove")
    public String removeTask(@RequestParam int taskID, @RequestParam String taskName, @RequestParam String info, @RequestParam int priority, @RequestParam boolean inProgress, @RequestParam boolean isCompleted) {
        Task task = new Task(taskID, taskName, info, priority, inProgress, isCompleted);
        taskRepository.removeTask(task);
        return "Success";
    }
}