package ru.sokoluk.TodoList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sokoluk.TodoList.entity.Task;
import ru.sokoluk.TodoList.entity.Title;
import ru.sokoluk.TodoList.services.TitleService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/todo-lists")
@CrossOrigin("*")
//
public class TitleController {

    private TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping()
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
        System.out.println("333");
        titleService.deleteTitle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{todolistId}")
    public ResponseEntity<Title> changeTitle(@PathVariable int todolistId,
                                             @RequestBody Title title) {
        System.out.println("4444");
        return new ResponseEntity<>(titleService.renameTitle(todolistId, title), HttpStatus.OK);
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

    @PatchMapping("/{todolistId}/tasks/{taskId}")
    public ResponseEntity<Task> changeTask(@PathVariable("todolistId") int titleId, @PathVariable("taskId") int taskId, @RequestBody Task task){
        System.out.println("11");
        return new ResponseEntity<>(titleService.renameTask(titleId,taskId,task), OK);
    }

    @DeleteMapping("/{todolistId}/tasks/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable("taskId") int taskId) {
        titleService.deleteTask(taskId);
        return new ResponseEntity<>(OK);
    }
}
