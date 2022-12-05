package ru.sokoluk.TodoList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sokoluk.TodoList.entity.Task;
import ru.sokoluk.TodoList.entity.Title;
import ru.sokoluk.TodoList.repository.TasksRepository;
import ru.sokoluk.TodoList.repository.TitlesRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class TitleService {

    private final TitlesRepository titlesRepository;

    private final TasksRepository tasksRepository;

    @Autowired
    public TitleService(TitlesRepository titlesRepository, TasksRepository tasksRepository) {
        this.titlesRepository = titlesRepository;
        this.tasksRepository = tasksRepository;
    }


    public List<Title> findAllTitles() {
        return titlesRepository.findAll().stream().sorted(Comparator.comparing(Title::getId).reversed()).collect(Collectors.toList());
    }

    @Transactional
    public Title newTitle(Title title) {
        return titlesRepository.save(title);
    }

    @Transactional
    public void deleteTitle(int id) {
        titlesRepository.deleteById(id);
    }

    @Transactional
    public Title renameTitle(int id, Title updateTitle) {
        Title title = titlesRepository.getById(id);
        title.setTitle(updateTitle.getTitle());
        return titlesRepository.save(title);
    }

    public List<Task> findAllTasks(int id) {
        return titlesRepository.getById(id).getTasks().stream().sorted(Comparator.comparing(Task::getId).reversed()).collect(Collectors.toList());
    }

    @Transactional
    public Task newTask(int id, Task task) {
        Task task1 = new Task(task.getTask(), titlesRepository.getById(id));
        return tasksRepository.save(task1);
    }

    @Transactional
    public Task renameTask(int titleId, int taskId, Task updatedTask) {
        Title title = titlesRepository.getById(titleId);
        Task task = new Task();
        for (Task it : title.getTasks()) {
            if (it.getId() == taskId) {
                task = it;
                if(updatedTask.getTask() != null)
                it.setTask(updatedTask.getTask());
                it.setActive(updatedTask.isActive());
            }
        }
        return tasksRepository.save(task);
    }

    @Transactional
    public void deleteTask(int taskId) {
        tasksRepository.deleteById(taskId);
    }
}
