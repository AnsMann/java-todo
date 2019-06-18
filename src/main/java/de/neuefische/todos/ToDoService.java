package de.neuefische.todos;


import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    private ListService listService;
    private ToDoRepository toDoRepository;

    public ToDoService(ListService listService, ToDoRepository toDoRepository) {
        this.listService = listService;
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findByList(String id) {
        return this.listService.findListById(id).getTodos();
    }

    public List<ToDo> addTodoToList(String title, String id) {
        TodoList newList = this.listService.findListById(id);
        ToDo newTodo = newList.addTodo(title);
        this.toDoRepository.save(newTodo);
        this.listService.saveTodoList(newList);
        return newList.getTodos();
    }

    public List<ToDo> getAllTodos() {
        return this.toDoRepository.findAll();
    }

    public void deleteTodo(String id) {
        this.toDoRepository.deleteById(id);
    }

    public ToDo getTodo(String id) throws ModelNotFoundException {
        return this.toDoRepository.findById(id)
                .orElseThrow(ModelNotFoundException::new);
    }

    public void editTodoName(String id, String title) {
        ToDo newTodo = this.getTodo(id);
        newTodo.setTitle(title);
        this.toDoRepository.save(newTodo);
    }
}
