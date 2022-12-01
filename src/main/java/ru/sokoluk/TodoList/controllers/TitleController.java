package ru.sokoluk.TodoList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sokoluk.TodoList.entity.Task;
import ru.sokoluk.TodoList.entity.Title;
import ru.sokoluk.TodoList.services.TitleService;

import java.util.List;

@RestController
@RequestMapping("/todo-lists")
@CrossOrigin(origins = "https://spring-boot-todo-serv.herokuapp.com")
public class TitleController {

    private TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("")
    public ResponseEntity<List<Title>> showTitles() {
        System.out.println("2222");
        return new ResponseEntity<>(titleService.findAllTitles(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Title> createTitle(@RequestBody Title title) {
        System.out.println("1111");
        return new ResponseEntity<>(titleService.newTitle(title), HttpStatus.OK);
    }

    @DeleteMapping("/{todolistId}")
    public ResponseEntity<Title> deleteTitle(@PathVariable("todolistId") int id) {
        titleService.deleteTitle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{todolistId}")
    public ResponseEntity<Title> changeTitle(@PathVariable("todolistId") int id, @RequestBody Title title) {
        return new ResponseEntity<>(titleService.renameTitle(id, title), HttpStatus.OK);
    }

    @GetMapping("/{todolistId}/tasks")
    public ResponseEntity<List<Task>> showTasks(@PathVariable("todolistId") int id) {
        return new ResponseEntity<>(titleService.findAllTasks(id), HttpStatus.OK);
    }

    @PostMapping("/{todolistId}/tasks") // Принимаю строку??
    public ResponseEntity<Task> createTask(@PathVariable("todolistId") int id, @RequestBody Task task) {
        System.out.println("11");
        return new ResponseEntity<>(titleService.newTask(id, task), HttpStatus.OK);
    }

    @PutMapping("/{todolistId}/tasks/{taskId}")
    public ResponseEntity<Title> changeTask(@PathVariable("todolistId") int titleId, @PathVariable("taskId") int taskId, @RequestBody Task task){
        System.out.println("11");
        return new ResponseEntity<>(titleService.renameTask(titleId,taskId,task), HttpStatus.OK);
    }

    @DeleteMapping("/{todolistId}/tasks/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable("taskId") int taskId) {
        titleService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
