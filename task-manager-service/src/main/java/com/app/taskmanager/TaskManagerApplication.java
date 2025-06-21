package com.demo.taskmanager;


import org.springframework.beans.factory.annotation.Autowired;

//מאפשר להריץ קוד ברגע שעולה
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//מסמן שזו מחלקת האתחול הראשית של אפליקציה Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//מאפשר להריץ קוד מיד בעליה
public class TaskManagerApplication implements CommandLineRunner {

    @Autowired
    //משתנה המחזיק הפניה למחלקת service
    private TaskService service;

    //מפעיל פה את spring
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }


    //בודק שהמתודות נכונות

    @Override
    public void run(String... args) {
        service.createTask("ללמוד ספרינג", "לסיים את תרגיל הבית", "גבוה");
        service.createTask("לקנות מצרכים", "חלב, לחם, גבינה", "נמוך");

        System.out.println(" רשימת משימות:");
        service.getTasks().forEach(t -> System.out.println(t.getId() + ": " + t.getName() + " | חשיבות: " + t.getPriority()));
    }


}

