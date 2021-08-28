package com.crud.tasks.controller;


import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/v1")
public class TaskController {
    private List<TaskDto> tasks = new ArrayList<>();

    public TaskController() {
        init();
    }

    private void init() {
        this.tasks.add(new TaskDto(1L, "First task", "content1"));
        this.tasks.add(new TaskDto(2L, "Second task", "content2"));
        this.tasks.add(new TaskDto(3L, "Third task", "content3"));
    }

    @GetMapping(path = "/tasks")
    public List<TaskDto> getTasks() {
        return tasks;
    }

    @GetMapping(path = "/tasks/{taskId}")
    public TaskDto getTask(@PathVariable(name = "taskId") Long taskId) {
        return tasks.stream()
                .filter(t -> t.getId().equals(taskId))
                .findAny().get();
    }

    @DeleteMapping(path = "/tasks/{taskId}")
    public void deleteTask(@PathVariable(name = "taskId") Long taskId) {
        tasks.removeIf(t -> t.getId().equals(taskId));
    }

    @PutMapping(path = "/tasks")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {

        for (TaskDto task : tasks) {
            if (task.getId().equals(taskDto.getId())) {
                task.setTitle(taskDto.getTitle());
                task.setContent(taskDto.getContent());
            }
        }

        return taskDto;
    }

    @PostMapping(path = "/tasks")
    public void createTask(TaskDto taskDto) {

    }
}