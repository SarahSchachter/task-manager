import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [tasks, setTasks] = useState([]);
  const [form, setForm] = useState({ name: "", description: "", priority: "low" });

  const fetchTasks = async () => {
    const res = await axios.get("http://localhost:8080/tasks");
    setTasks(res.data);
  };

  useEffect(() => {
    fetchTasks();
  }, []);


  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/tasks", form);
    setForm({ name: "", description: "", priority: "low" });
    fetchTasks();
  };

  const completeTask = async (id) => {
    await axios.put(`http://localhost:8080/tasks/${id}/complete`);
    fetchTasks();
  };

  const deleteTask = async (id) => {
    await axios.delete(`http://localhost:8080/tasks/${id}`);
    fetchTasks();
  };

  return (
    <div className="app">
      <h1>📝 Task Manager</h1>

      <form onSubmit={handleSubmit} className="form">
        <input
          type="text"
          placeholder="שם משימה"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
          required
        />
        <input
          type="text"
          placeholder="תיאור"
          value={form.description}
          onChange={(e) => setForm({ ...form, description: e.target.value })}
          required
        />
        <select
          value={form.priority}
          onChange={(e) => setForm({ ...form, priority: e.target.value })}
        >
          <option value="high">גבוה</option>
          <option value="medium">בינוני</option>
          <option value="low">נמוך</option>
        </select>
        <button type="submit">➕ הוסף משימה</button>
      </form>

      <ul className="task-list">
        {tasks.map((task) => (
          <li
            key={task.id}
            className={`task-item priority-${task.priority} ${task.completed ? "completed" : ""}`}
          >
            <div>
              <strong>{task.name}</strong> - {task.description} 
              {/* <span className="priority">[{task.priority}]</span> */}
            </div>
            <div className="actions">
              {!task.completed && (
                <button onClick={() => completeTask(task.id)}>✅</button>
              )}
              <button onClick={() => deleteTask(task.id)}>🗑️</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
