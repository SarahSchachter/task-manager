package com.demo.taskmanager;


import org.springframework.beans.factory.annotation.Autowired;

//יבוא האנוטציה service מספריית Spring framework
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    //משתנה המחזיק הפניה למחלקת repository
    private final TaskRepository repository;

    //פעןלת איתחול למחלקת Repository
    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String name, String description, String priority) {
        return repository.addTask(name, description, priority);
    }
    public List<Task> getTasks() {
        return repository.getAllTasks();
    }

    public boolean completeTask(int id) {
        return repository.markTaskAsCompleted(id);
    }

    public boolean deleteTask(int id) {
        return repository.deleteTask(id);
    }
}
