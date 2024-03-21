package com.example.backendspringsecurity.service;

import com.example.backendspringsecurity.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    public Task saveTask(Task task);

    public List<Task> getAllTasks();

    public Optional<Task> getTaskById(Long id);

    public Task updateTask(Task task);

    public void deleteTask(Long id);
}
