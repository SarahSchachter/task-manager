package com.demo.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getTasks();
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        service.createTask(task.getName(), task.getDescription(), task.getPriority());
    }

    @PutMapping("/{id}/complete")
    public void completeTask(@PathVariable int id) {
        service.completeTask(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}



