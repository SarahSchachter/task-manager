package com.demo.taskmanager;

//יבוא האנוטציה Repository מספריית Spring framework
import org.springframework.stereotype.Repository;

//יבוא כל ספרית util מjava
import java.util.*;

@Repository
public class TaskRepository {

    //מפה המאכסנת את כל המשימות
    private Map<Integer, Task> tasks = new HashMap<>();

    //משתנה לספירת מזהים להוספת משימה
    private int currentId = 1;

    //הוספת משימה חדשה
    public Task addTask(String name, String description, String priority) {
        Task task = new Task(currentId++, name, description, priority);
        tasks.put(task.getId(), task);
        return task;
    }

    //מחזיר את רשימה כל המשימות הקיימות
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    //מחזיר משימה כ"י מזהה המשימה
    public Task findTaskById(int id) {
        return tasks.get(id);
    }

    //מסמן משימה כ"הושלמה"
    public boolean markTaskAsCompleted(int id) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setCompleted(true);
            return true;
        }
        return false;
    }
    //מחיקת משימה לפי המזהה
    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }
}

