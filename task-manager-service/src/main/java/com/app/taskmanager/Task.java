package com.demo.taskmanager;

//הגדרת תכונות של מחלקת משימה
public class Task {
    private int id;
    private String name;
    private String description;
    private boolean completed;
    private String priority; //  רמת חשיבות


    //בנאי של המחלקה, מאתחל את המשמימה ללא הושלמה
    public Task(int id, String name, String description, String priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = false;
        this.priority = priority;

    }

    // גטרים וסטרים
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public String getPriority() {return priority;}

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setPriority(String priority) {this.priority = priority;}

}
